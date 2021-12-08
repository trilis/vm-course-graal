/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.lama.parser;

import java.util.*;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.lama.builtins.*;
import com.oracle.truffle.lama.nodes.*;
import com.oracle.truffle.lama.nodes.controlflow.*;
import com.oracle.truffle.lama.nodes.expression.*;
import com.oracle.truffle.lama.nodes.local.LamaReaderHelperNodeGen;
import com.oracle.truffle.lama.nodes.patterns.LamaArrayPatternNodeGen;
import com.oracle.truffle.lama.nodes.patterns.LamaNamedPatternNode;
import com.oracle.truffle.lama.nodes.patterns.LamaPatternNode;
import com.oracle.truffle.lama.nodes.patterns.LamaSexpPatternNodeGen;
import com.oracle.truffle.lama.runtime.LamaFunction;
import org.antlr.v4.runtime.Token;

import com.oracle.truffle.lama.nodes.expression.LamaReferenceNodeGen;
import com.oracle.truffle.lama.nodes.local.LamaReadArgumentNode;
import com.oracle.truffle.lama.nodes.local.SLReadNodeGen;
import com.oracle.truffle.lama.nodes.local.SLWriteNodeGen;

public class LamaNodeFactory {

    private FrameDescriptor frameDescriptor;

    private LexicalScope lexicalScope;

    class LexicalScope {
        protected final LexicalScope outer;
        private final Map<String, FrameSlot> locals;
        private final Set<String> promised;

        LexicalScope(LexicalScope outer) {
            this.outer = outer;
            this.locals = new HashMap<>();
            this.promised = new HashSet<>();
            if (outer != null) {
                locals.putAll(outer.locals);
            }
        }

        public FrameSlot get(String name) {
            FrameSlot slot = locals.get(name);
            if (slot != null) {
                return slot;
            }
            promised.add(name);
            slot = put(name, null);
            return slot;
        }

        public void register(String name) {
            promised.remove(name);
        }

        public FrameSlot put(String name, Integer argumentIndex) {
            FrameSlot slot = frameDescriptor.findOrAddFrameSlot(
                    name,
                    argumentIndex,
                    FrameSlotKind.Illegal);
            locals.put(name, slot);
            return slot;
        }

        public void cleanUp() {
            if (outer == null && !promised.isEmpty()) {
                throw new RuntimeException("Unknown variables: " + String.join(", ", promised));
            }
            for (String name : promised) {
                outer.promised.add(name);
                outer.locals.put(name, locals.get(name));
            }
        }
    }

    public void initialize() {
        frameDescriptor = new FrameDescriptor();
        startBlock();
    }

    private List<LamaExpressionNode> installBuiltins() {
        List<LamaExpressionNode> builtins = new ArrayList<>();
        builtins.add(installBuiltin(LamaReadBuiltinFactory.getInstance(), "read"));
        builtins.add(installBuiltin(LamaWriteBuiltinFactory.getInstance(), "write"));
        builtins.add(installBuiltin(LamaLengthBuiltinFactory.getInstance(), "length"));
        builtins.add(installBuiltin(LamaStringBuiltinFactory.getInstance(), "string"));
        return builtins;
    }

    public LamaExpressionNode installBuiltin(NodeFactory<? extends LamaBuiltinNode> factory, String name) {
        LamaFunction builtin = LamaBuiltinNode.createBuiltinFunction(factory, frameDescriptor);
        registerVariable(name);
        return createAssignment(
                new LamaStringLiteralNode(new StringBuffer(name)),
                LamaFunctionNodeGen.create(builtin)
        );
    }

    public LamaRootNode finishAll(LamaExpressionNode bodyNode) {
        List<LamaExpressionNode> methodNodes = new ArrayList<>(installBuiltins());
        methodNodes.add(bodyNode);
        final int bodyEndPos = bodyNode.getSourceEndIndex();
        final LamaExpressionNode methodBlock = finishBlock(methodNodes, 0, bodyEndPos, true);
        if (lexicalScope != null) {
            throw new RuntimeException("Wrong scoping of blocks in parser");
        }
        return new LamaRootNode(methodBlock, frameDescriptor);
    }

    public LamaExpressionNode createLambda(List<LamaPatternNode> argPatterns, LamaExpressionNode bodyNode, Token functionBodyStartToken) {
        List<LamaExpressionNode> methodNodes = new ArrayList<>();
        Collections.reverse(argPatterns);
        int parameterCount = 0;

        for (LamaPatternNode argPattern : argPatterns) {
            final LamaReadArgumentNode readArg = new LamaReadArgumentNode(argPatterns.size() - 1 - parameterCount);
            bodyNode = createCase(readArg, Collections.singletonList(argPattern), Collections.singletonList(bodyNode));
            parameterCount++;
        }

        methodNodes.add(bodyNode);

        final int bodyEndPos = bodyNode.getSourceEndIndex();
        int functionBodyStartPos = functionBodyStartToken.getStartIndex();
        final LamaExpressionNode methodBlock = finishBlock(methodNodes, parameterCount, functionBodyStartPos, bodyEndPos - functionBodyStartPos, true);
        return LamaFunctionNodeGen.create(
                new LamaFunction(Truffle.getRuntime().createCallTarget(
                        new LamaRootNode(methodBlock, frameDescriptor)
                ))
        );
    }

    public LamaExpressionNode createEta(LamaExpressionNode bodyNode) {
        List<LamaExpressionNode> methodNodes = new ArrayList<>();
        LamaReadArgumentNode readArg = new LamaReadArgumentNode(0);
        methodNodes.add(new LamaInvokeNode(bodyNode, new LamaExpressionNode[]{readArg}));
        final LamaExpressionNode methodBlock = finishBlock(methodNodes, 1, -1, 0, false);
        return LamaFunctionNodeGen.create(
                new LamaFunction(Truffle.getRuntime().createCallTarget(
                        new LamaRootNode(methodBlock, frameDescriptor)
                ))
        );
    }

    public LamaExpressionNode createFunction(String name, List<LamaPatternNode> argPatterns, LamaExpressionNode bodyNode, Token functionBodyStartToken) {
        LamaExpressionNode lambda = createLambda(argPatterns, bodyNode, functionBodyStartToken);
        lexicalScope.register(name);
        lexicalScope.put(name, null);

        return createAssignment(
                new LamaStringLiteralNode(new StringBuffer(name)),
                lambda
        );
    }

    public void startBlock() {
        lexicalScope = new LexicalScope(lexicalScope);
    }

    public void endScope() {
        lexicalScope.cleanUp();
        lexicalScope = lexicalScope.outer;
    }

    public LamaExpressionNode finishBlock(List<LamaExpressionNode> bodyNodes, int startPos, int length, boolean shouldExit) {
        return finishBlock(bodyNodes, 0, startPos, length, shouldExit);
    }

    public LamaExpressionNode finishBlock(List<LamaExpressionNode> bodyNodes, int skipCount, int startPos, int length, boolean shouldExit) {
        if (shouldExit) {
            lexicalScope.cleanUp();
            lexicalScope = lexicalScope.outer;
        }

        if (containsNull(bodyNodes)) {
            return null;
        }

        List<LamaExpressionNode> flattenedNodes = new ArrayList<>(bodyNodes.size());
        flattenBlocks(bodyNodes, flattenedNodes);
        int n = flattenedNodes.size();
        for (int i = skipCount; i < n; i++) {
            LamaExpressionNode statement = flattenedNodes.get(i);
            if (statement.hasSource() && !isHaltInCondition(statement)) {
                statement.addStatementTag();
            }
        }
        LamaBlockNode blockNode = new LamaBlockNode(flattenedNodes.toArray(new LamaExpressionNode[0]));
        blockNode.setSourceSection(startPos, length);
        return blockNode;
    }

    private static boolean isHaltInCondition(LamaExpressionNode statement) {
        return (statement instanceof LamaIfNode) || (statement instanceof LamaWhileNode);
    }

    private void flattenBlocks(Iterable<? extends LamaExpressionNode> bodyNodes, List<LamaExpressionNode> flattenedNodes) {
        for (LamaExpressionNode n : bodyNodes) {
            if (n instanceof LamaBlockNode) {
                flattenBlocks(((LamaBlockNode) n).getStatements(), flattenedNodes);
            } else {
                flattenedNodes.add(n);
            }
        }
    }

    public LamaExpressionNode createWhile(Token whileToken, LamaExpressionNode conditionNode, LamaExpressionNode bodyNode) {
        if (conditionNode == null || bodyNode == null) {
            return null;
        }

        conditionNode.addStatementTag();
        final int start = whileToken.getStartIndex();
        final int end = bodyNode.getSourceEndIndex();
        final LamaWhileNode whileNode = new LamaWhileNode(conditionNode, bodyNode);
        whileNode.setSourceSection(start, end - start);
        return whileNode;
    }

    public LamaExpressionNode createDoWhile(Token whileToken, LamaExpressionNode conditionNode, LamaExpressionNode bodyNode) {
        final LamaExpressionNode whileNode = createWhile(whileToken, conditionNode, bodyNode);
        final int start = whileToken.getStartIndex();
        final int end = bodyNode.getSourceEndIndex();

        List<LamaExpressionNode> block = new ArrayList<>();
        block.add(bodyNode);
        block.add(whileNode);

        return finishBlock(block, start, end, true);
    }

    public LamaExpressionNode createFor(Token forToken, LamaExpressionNode initNode, LamaExpressionNode conditionNode, LamaExpressionNode incNode, LamaExpressionNode bodyNode) {
        if (initNode == null || conditionNode == null || incNode == null || bodyNode == null) {
            return null;
        }
        final int start = forToken.getStartIndex();
        final int end = bodyNode.getSourceEndIndex();

        List<LamaExpressionNode> bodyBlockExpressions = new ArrayList<>();
        bodyBlockExpressions.add(bodyNode);
        bodyBlockExpressions.add(incNode);
        LamaExpressionNode bodyBlock = finishBlock(bodyBlockExpressions, start, end, false);

        final LamaExpressionNode whileNode = createWhile(forToken, conditionNode, bodyBlock);

        List<LamaExpressionNode> block = new ArrayList<>();
        block.add(initNode);
        block.add(whileNode);

        return finishBlock(block, start, end, true);
    }

    public LamaExpressionNode createIf(Token ifToken, LamaExpressionNode conditionNode, LamaExpressionNode thenPartNode, LamaExpressionNode elsePartNode) {
        if (conditionNode == null || thenPartNode == null) {
            return null;
        }

        conditionNode.addStatementTag();
        final int start = ifToken.getStartIndex();
        final int end = elsePartNode == null ? thenPartNode.getSourceEndIndex() : elsePartNode.getSourceEndIndex();
        final LamaIfNode ifNode = new LamaIfNode(conditionNode, thenPartNode, elsePartNode);
        ifNode.setSourceSection(start, end - start);
        return ifNode;
    }

    public LamaExpressionNode createBinary(Token opToken, LamaExpressionNode leftNode, LamaExpressionNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return null;
        }
        final LamaExpressionNode result;
        switch (opToken.getText()) {
            case "+":
                result = LamaAddNodeGen.create(leftNode, rightNode);
                break;
            case "*":
                result = LamaMulNodeGen.create(leftNode, rightNode);
                break;
            case "/":
                result = LamaDivNodeGen.create(leftNode, rightNode);
                break;
            case "%":
                result = LamaModNodeGen.create(leftNode, rightNode);
                break;
            case "-":
                result = LamaSubNodeGen.create(leftNode, rightNode);
                break;
            case "<":
                result = LamaLessThanNodeGen.create(leftNode, rightNode);
                break;
            case "<=":
                result = LamaLessOrEqualNodeGen.create(leftNode, rightNode);
                break;
            case ">":
                result = LamaLogicalNotNodeGen.create(LamaLessOrEqualNodeGen.create(leftNode, rightNode));
                break;
            case ">=":
                result = LamaLogicalNotNodeGen.create(LamaLessThanNodeGen.create(leftNode, rightNode));
                break;
            case "==":
                result = LamaEqualNodeGen.create(leftNode, rightNode);
                break;
            case "!=":
                result = LamaLogicalNotNodeGen.create(LamaEqualNodeGen.create(leftNode, rightNode));
                break;
            case "&&":
                result = new LamaLogicalAndNode(leftNode, rightNode);
                break;
            case "!!":
                result = new LamaLogicalOrNode(leftNode, rightNode);
                break;
            default:
                throw new RuntimeException("unexpected operation: " + opToken.getText());
        }

        int start = leftNode.getSourceCharIndex();
        int length = rightNode.getSourceEndIndex() - start;
        result.setSourceSection(start, length);
        result.addExpressionTag();

        return result;
    }

    public LamaExpressionNode createCall(LamaExpressionNode functionNode, List<LamaExpressionNode> parameterNodes, Token finalToken) {
        if (functionNode == null || containsNull(parameterNodes)) {
            return null;
        }

        final LamaExpressionNode result = new LamaInvokeNode(functionNode, parameterNodes.toArray(new LamaExpressionNode[0]));

        final int startPos = functionNode.getSourceCharIndex();
        final int endPos = finalToken.getStartIndex() + finalToken.getText().length();
        result.setSourceSection(startPos, endPos - startPos);
        result.addExpressionTag();

        return result;
    }

    public LamaExpressionNode createAssignment(LamaExpressionNode nameNode, LamaExpressionNode valueNode) {
        return createAssignment(nameNode, valueNode, null);
    }

    public void registerVariable(String name) {
        lexicalScope.register(name);
        lexicalScope.put(name, null);
    }

    public LamaExpressionNode createAssignment(LamaExpressionNode nameNode, LamaExpressionNode valueNode, Integer argumentIndex) {
        if (nameNode == null || valueNode == null) {
            return null;
        }

        final LamaExpressionNode result = SLWriteNodeGen.create(createReference(nameNode), valueNode);

        if (valueNode.hasSource()) {
            final int start = nameNode.getSourceCharIndex();
            final int length = valueNode.getSourceEndIndex() - start;
            result.setSourceSection(start, length);
        }
        if (argumentIndex == null) {
            result.addExpressionTag();
        }

        return result;
    }

    public LamaExpressionNode createRead(LamaExpressionNode nameNode) {
        if (nameNode == null) {
            return null;
        }
        String name = ((LamaStringLiteralNode) nameNode).executeGeneric(null).toString();
        final LamaExpressionNode result;
        final FrameSlot frameSlot = lexicalScope.get(name);
        result = SLReadNodeGen.create(frameSlot);
        result.setSourceSection(nameNode.getSourceCharIndex(), nameNode.getSourceLength());
        result.addExpressionTag();
        return result;
    }

    public LamaExpressionNode createReference(LamaExpressionNode nameNode) {
        if (nameNode == null) {
            return null;
        }

        String name = ((LamaStringLiteralNode) nameNode).executeGeneric(null).toString();
        final LamaExpressionNode result;
        final FrameSlot frameSlot = lexicalScope.get(name);
        result = LamaReferenceNodeGen.create(frameSlot);
        result.setSourceSection(nameNode.getSourceCharIndex(), nameNode.getSourceLength());
        result.addExpressionTag();
        return result;
    }

    public LamaExpressionNode createElem(LamaExpressionNode objectNode, LamaExpressionNode indexNode) {
        return LamaElemNodeGen.create(objectNode, indexNode);
    }

    public LamaExpressionNode createElemRef(LamaExpressionNode objectNode, LamaExpressionNode indexNode) {
        return LamaElemRefNodeGen.create(objectNode, LamaReaderHelperNodeGen.create(), indexNode);
    }

    public long parseChar(Token charToken) {
        StringBuffer literal = trim(charToken.getText(), "'");
        char result = literal.charAt(0);
        if (literal.charAt(0) == '\'') {
            result = '\'';
        } else if (literal.charAt(0) == '\\') {
            if (literal.charAt(1) == 'n') {
                result = '\n';
            } else if (literal.charAt(1) == 't') {
                result = '\t';
            }
        }
        return result;
    }

    public LamaExpressionNode createCharLiteral(Token charToken) {
        final LamaExpressionNode expression = new LamaLongLiteralNode(parseChar(charToken));
        srcFromToken(expression, charToken);
        expression.addExpressionTag();
        return expression;
    }

    public StringBuffer trim(String literal, String delim) {
        assert literal.length() >= 2 && literal.startsWith(delim) && literal.endsWith(delim);
        return new StringBuffer(literal.substring(1, literal.length() - 1));
    }

    public LamaExpressionNode createStringLiteral(Token literalToken, boolean removeQuotes) {
        StringBuffer literal = new StringBuffer(literalToken.getText().replaceAll("\"\"", "\""));
        if (removeQuotes) {
            literal = trim(literal.toString(), "\"");
        }
        final LamaStringLiteralNode result = new LamaStringLiteralNode(literal);
        srcFromToken(result, literalToken);
        result.addExpressionTag();
        return result;
    }

    public LamaExpressionNode createNumericLiteral(Token literalToken, long sign) {
        LamaExpressionNode result;
        result = new LamaLongLiteralNode(Long.parseLong(literalToken.getText()) * sign);
        srcFromToken(result, literalToken);
        result.addExpressionTag();
        return result;
    }

    public LamaExpressionNode createWriteProperty(LamaExpressionNode receiverNode, LamaExpressionNode valueNode) {
        if (receiverNode == null || valueNode == null) {
            return null;
        }

        final LamaExpressionNode result = SLWriteNodeGen.create(receiverNode, valueNode);

        final int start = receiverNode.getSourceCharIndex();
        final int length = valueNode.getSourceEndIndex() - start;
        result.setSourceSection(start, length);
        result.addExpressionTag();

        return result;
    }

    public LamaExpressionNode createAssignments(List<LamaExpressionNode> refs, LamaExpressionNode value) {
        if (value == null || containsNull(refs)) {
            return null;
        }
        Collections.reverse(refs);
        return refs.stream().reduce(value, (acc, ref) -> createWriteProperty(ref, acc));
    }

    public LamaExpressionNode createSexp(String constructorName, List<LamaExpressionNode> args) {
        return new LamaSexpLiteralNode(constructorName, args.toArray(new LamaExpressionNode[0]));
    }

    public LamaExpressionNode createList(LamaExpressionNode base, List<LamaExpressionNode> args) {
        Collections.reverse(args);
        for (LamaExpressionNode arg : args) {
            List<LamaExpressionNode> consArgs = new ArrayList<>();
            consArgs.add(arg);
            consArgs.add(base);
            base = createSexp("cons", consArgs);
        }
        return base;
    }

    public LamaExpressionNode createArray(List<LamaExpressionNode> args) {
        return new LamaArrayLiteralNode(args.toArray(new LamaExpressionNode[0]));
    }

    public LamaExpressionNode createCase(LamaExpressionNode scrutinee, List<LamaPatternNode> patterns, List<LamaExpressionNode> branches) {
        return new LamaCaseNode(scrutinee, patterns.toArray(new LamaPatternNode[0]), branches.toArray(new LamaExpressionNode[0]));
    }

    public LamaPatternNode createNamedPattern(String name, LamaPatternNode pattern) {
        lexicalScope.register(name);
        FrameSlot frameSlot = lexicalScope.put(name, null);
        return new LamaNamedPatternNode(frameSlot, pattern);
    }

    public LamaPatternNode createArrayPattern(List<LamaPatternNode> subpatterns) {
        return LamaArrayPatternNodeGen.create(subpatterns.toArray(new LamaPatternNode[0]));
    }

    public LamaPatternNode createSexpPattern(String constructorName, List<LamaPatternNode> subpatterns) {
        return LamaSexpPatternNodeGen.create(constructorName, subpatterns.toArray(new LamaPatternNode[0]));
    }

    public LamaPatternNode createConsPattern(LamaPatternNode base, List<LamaPatternNode> subpatterns) {
        Collections.reverse(subpatterns);
        for (LamaPatternNode subpattern : subpatterns) {
            List<LamaPatternNode> consSubpatterns = new ArrayList<>();
            consSubpatterns.add(subpattern);
            consSubpatterns.add(base);
            base = createSexpPattern("cons", consSubpatterns);
        }
        return base;
    }

    private static void srcFromToken(LamaExpressionNode node, Token token) {
        node.setSourceSection(token.getStartIndex(), token.getText().length());
    }

    private static boolean containsNull(List<?> list) {
        for (Object e : list) {
            if (e == null) {
                return true;
            }
        }
        return false;
    }

}

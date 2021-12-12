/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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

/*
 * The parser and lexer need to be generated using "generate_parser.sh".
 */

grammar LamaLanguage;

@parser::header
{
// DO NOT MODIFY - generated from LamaLanguage.g4 using "generate_parser.sh"

import java.util.*;

import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.lama.LamaLanguage;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.nodes.expression.LamaSkipNode;
import static com.oracle.truffle.lama.parser.LamaLanguageParser.LamaSyntaxCategory.*;
import com.oracle.truffle.lama.nodes.LamaRootNode;
import com.oracle.truffle.lama.nodes.LamaStatementNode;
import com.oracle.truffle.lama.parser.LamaParseError;
import com.oracle.truffle.lama.nodes.expression.LamaLongLiteralNode;
import com.oracle.truffle.lama.nodes.patterns.*;
}

@lexer::header
{
// DO NOT MODIFY - generated from LamaLanguage.g4 using "generate_parser.sh"
}

@parser::members
{
private LamaNodeFactory factory;
private Source source;

private static final class BailoutErrorListener extends BaseErrorListener {
    private final Source source;
    BailoutErrorListener(Source source) {
        this.source = source;
    }
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throwParseError(source, line, charPositionInLine, (Token) offendingSymbol, msg);
    }
}

public void SemErr(Token token, String message) {
    assert token != null;
    throwParseError(source, token.getLine(), token.getCharPositionInLine(), token, message);
}

private static void throwParseError(Source source, int line, int charPositionInLine, Token token, String message) {
    int col = charPositionInLine + 1;
    String location = "-- line " + line + " col " + col + ": ";
    int length = token == null ? 1 : Math.max(token.getStopIndex() - token.getStartIndex(), 0);
    throw new LamaParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
}

public static LamaRootNode parseLama(LamaLanguage language, Source source) {
    LamaLanguageLexer lexer = new LamaLanguageLexer(CharStreams.fromString(source.getCharacters().toString()));
    LamaLanguageParser parser = new LamaLanguageParser(new CommonTokenStream(lexer));
    lexer.removeErrorListeners();
    parser.removeErrorListeners();
    BailoutErrorListener listener = new BailoutErrorListener(source);
    lexer.addErrorListener(listener);
    parser.addErrorListener(listener);
    parser.factory = new LamaNodeFactory();
    parser.source = source;
    return parser.lama().result;
}

public enum LamaSyntaxCategory {
    VAL, VOID, REF, ERROR
}

public void checkCategory(LamaSyntaxCategory expected, LamaSyntaxCategory actual, Token token) {
  if (expected != actual && !(expected == VOID && actual == VAL)) {
    SemErr(token, "expected " + expected + ", got " + actual);
  }
}

public static final class SuffixResult {
  public SuffixResult(List<LamaExpressionNode> nodes, Token end) {
    this.nodes = nodes;
    this.end = end;
  }

  public List<LamaExpressionNode> nodes;
  public Token end;
}

}

// parser

lama returns [LamaRootNode result]:
{ factory.initialize(); } e=scope_expression[VOID, true] EOF { $result=factory.finishAll($e.result); };

scope_expression[LamaSyntaxCategory cat, boolean shouldExit] returns [LamaExpressionNode result]:
{ factory.startBlock();
  List<LamaExpressionNode> body = new ArrayList<>(); }
(d=definition { body.addAll($d.result); }
)* e=possible_expression[cat] { if ($e.result != null) {
  body.add($e.result);
}
$result = factory.finishBlock(body,  $start.getStartIndex(), $e.stop.getStopIndex() - $start.getStartIndex() + 1, shouldExit);
};

possible_expression[LamaSyntaxCategory cat] returns [LamaExpressionNode result]:
(e=expression[cat] { $result = $e.result; }
)?
;

definition returns [List<LamaExpressionNode> result]
:
vd=variable_definition { $result = $vd.result; }
|
fd=function_definition { $result = new ArrayList<>(); $result.add($fd.result); }
;

variable_definition returns [List<LamaExpressionNode> result]
:
{ $result = new ArrayList<>(); }
'var' v1=variable_definition_item { if ($v1.result != null) { $result.add($v1.result); } }
(',' v2=variable_definition_item { if ($v2.result != null) { $result.add($v2.result); } }
)*
';'
;

variable_definition_item returns [LamaExpressionNode result]
:
v=LIDENT { factory.registerVariable($v.getText()); } (
'=' e=binary_expression[VAL] { $result = factory.createAssignment(factory.createStringLiteral($v, false), $e.result); }
)?
;

function_definition returns [LamaExpressionNode result]
:
'fun' name=LIDENT br='('
{ factory.startFunction(); } args=function_args ')' '{'
body=scope_expression[VOID, true]
'}' { $result = factory.createFunction($name.getText(), $args.result, $body.result, $br); }
;

lambda_definition returns [LamaExpressionNode result]
:
br='('
{ factory.startFunction(); } args=function_args ')' '{'
body=scope_expression[VOID, true]
'}' { $result = factory.createLambda($args.result, $body.result, $br); }
;

function_args returns [List<LamaPatternNode> result]
:
{ $result = new ArrayList<>(); }
( p=pattern { $result.add($p.result); }
  (',' p=pattern { $result.add($p.result); }
  )*
)?
;

expression[LamaSyntaxCategory cat] returns [LamaExpressionNode result]
:
{ List<LamaExpressionNode> body = new ArrayList<>();
  int end = 0; }
(e=binary_expression[VOID] { body.add($e.result);
                      end = $e.stop.getStopIndex(); }
  ';')*
f=binary_expression[cat] { body.add($f.result);
                      end = $f.stop.getStopIndex(); }
{ $result = factory.finishBlock(body, $start.getStartIndex(), end - $start.getStartIndex() + 1, false); }
;

/*
lots of manual work here, because ANTLR doesn't support left recursion with parameters
*/

binary_expression[LamaSyntaxCategory cat] returns [LamaExpressionNode result]
:
{ List<LamaExpressionNode> refs = new ArrayList<>(); }
(e=binary_expression_col[REF] ':='
{ refs.add($e.result); }
)+
e1=binary_expression_col[VAL] {
  $result = factory.createAssignments(refs, $e1.result);
  checkCategory(cat, VAL, $e1.start); }
|
e=binary_expression_col[cat] { $result = $e.result; }
;

binary_expression_col[LamaSyntaxCategory cat] returns [LamaExpressionNode result]
:
{ List<LamaExpressionNode> args = new ArrayList<>(); }
(e1=binary_expression_or[VAL] ':' {args.add($e1.result); } )+
base=binary_expression_or[VAL]
{ $result = factory.createList($base.result, args);
  checkCategory(cat, VAL, $base.start); }
|
e=binary_expression_or[cat] { $result = $e.result; }
;

binary_expression_or[LamaSyntaxCategory cat] returns [LamaExpressionNode result]
:
e1=binary_expression_and[VAL] { $result = $e1.result; checkCategory(cat, VAL, $e1.start); }
(op='!!' e2=binary_expression_and[VAL]
{ $result = factory.createBinary($op, $result, $e2.result); }
)+
|
e=binary_expression_and[cat] { $result = $e.result; }
;

binary_expression_and[LamaSyntaxCategory cat] returns [LamaExpressionNode result]
:
e1=binary_expression_cmp[VAL] {$result = $e1.result; checkCategory(cat, VAL, $e1.start); }
(op='&&' e2=binary_expression_cmp[VAL]
{ $result = factory.createBinary($op, $result, $e2.result); }
)+
|
e=binary_expression_cmp[cat] { $result = $e.result; }
;

binary_expression_cmp[LamaSyntaxCategory cat] returns [LamaExpressionNode result]
:
e1=binary_expression_add[VAL] {$result = $e1.result; checkCategory(cat, VAL, $e1.start); }
(op=('=='|'!='|'>'|'<'|'>='|'<=') e2=binary_expression_add[VAL]
{ $result = factory.createBinary($op, $result, $e2.result); }
)+
|
e=binary_expression_add[cat] { $result = $e.result; }
;

binary_expression_add[LamaSyntaxCategory cat] returns [LamaExpressionNode result]
:
e1=binary_expression_mul[VAL] {$result = $e1.result; checkCategory(cat, VAL, $e1.start); }
(op=('+'|'-') e2=binary_expression_mul[VAL]
{ $result = factory.createBinary($op, $result, $e2.result); }
)+
|
e=binary_expression_mul[cat] { $result = $e.result; }
;

binary_expression_mul[LamaSyntaxCategory cat] returns [LamaExpressionNode result]
:
e1=postfix_expression[VAL] {$result = $e1.result; checkCategory(cat, VAL, $e1.start); }
(op=('*'|'/'|'%') e2=postfix_expression[VAL]
{ $result = factory.createBinary($op, $result, $e2.result); }
)+
|
e=postfix_expression[cat] { $result = $e.result; }
;

postfix_expression[LamaSyntaxCategory cat] returns [LamaExpressionNode result]
:
e=primary[cat]  { $result = $e.result; }
|
e=primary[cat] { $result = $e.result; }
(s=call_suffix
  {
      $result = factory.createCall($result, $s.result.nodes, $s.result.end);
      checkCategory(cat, VAL, $e.start);
  }
  |
  '[' ind=expression[VAL] ']'
  {
      if (cat == VAL || cat == VOID) {
        $result = factory.createElem($result, $ind.result);
      } else {
        $result = factory.createElemRef($result, $ind.result);
      }
  }
  |
  '.' LIDENT { List<LamaExpressionNode> parameters = new ArrayList<>(); parameters.add($result); Token end = $LIDENT; }
  (suf=call_suffix { parameters.addAll($suf.result.nodes); end = $suf.result.end; })?
  { $result = factory.createCall(factory.createRead(factory.createStringLiteral($LIDENT, false)), parameters, end); }
)+
;

call_suffix returns [SuffixResult result]
:
'('
{ List<LamaExpressionNode> parameters = new ArrayList<>(); }
(expression[VAL] { parameters.add($expression.result); }
(
','
expression[VAL] { parameters.add($expression.result); }
)*)?
end=')' { $result = new SuffixResult(parameters, $end); }
;

primary[LamaSyntaxCategory cat] returns [LamaExpressionNode result]:
DECIMAL { $result = factory.createNumericLiteral($DECIMAL, 1); checkCategory(cat, VAL, $DECIMAL); }
|
m='-' DECIMAL { $result = factory.createNumericLiteral($DECIMAL, -1); checkCategory(cat, VAL, $m); }
|
STRING { $result = factory.createStringLiteral($STRING, true); checkCategory(cat, VAL, $STRING); }
|
CHAR { $result = factory.createCharLiteral($CHAR); checkCategory(cat, VAL, $CHAR); }
|
LIDENT { if (cat == VAL || cat == VOID) {
          $result = factory.createRead(factory.createStringLiteral($LIDENT, false));
         } else {
          $result = factory.createReference(factory.createStringLiteral($LIDENT, false));
         } }
|
t='true' { $result = new LamaLongLiteralNode(1); checkCategory(cat, VAL, $t); }
|
f='false' { $result = new LamaLongLiteralNode(0); checkCategory(cat, VAL, $f); }
|
'(' e=scope_expression[cat, true] ')' { $result = $e.result; }
|
w='while' cond=expression[VAL] 'do' body=scope_expression[VOID, true] 'od'
{ $result = factory.createWhile($w, $cond.result, $body.result);
  checkCategory(cat, VOID, $w); }
|
i='if' {LamaExpressionNode elsePart = null; }
cond=expression[VAL] 'then' body=scope_expression[cat, true]
(el=else_part[cat] {elsePart = $el.result; })?
'fi' { $result = factory.createIf($i, $cond.result, $body.result, elsePart); }
|
w='do' body=scope_expression[VOID, false] 'while' cond=expression[VAL] 'od'
{ $result = factory.createDoWhile($w, $cond.result, $body.result);
  checkCategory(cat, VOID, $w); }
|
f='for'
init=scope_expression[VOID, false] ',' cond=expression[VAL] ',' inc=expression[VOID] 'do'
body=scope_expression[VOID, true] 'od'
{
  $result = factory.createFor($f, $init.result, $cond.result, $inc.result, $body.result);
  checkCategory(cat, VOID, $f);
}
|
s='skip' { $result = new LamaSkipNode(); checkCategory(cat, VOID, $s); }
|
c='case' scr=expression[VAL] 'of' { List<LamaPatternNode> patterns = new ArrayList<>();
                                    List<LamaExpressionNode> branches = new ArrayList<>();
                                    factory.startBlock(); }
p=pattern { patterns.add($p.result); } '->' e=scope_expression[cat, true]
{ branches.add($e.result); factory.endScope(); }
('|' { factory.startBlock(); } p=pattern { patterns.add($p.result); } '->' e=scope_expression[cat, true]
{ branches.add($e.result); factory.endScope(); })*
'esac' { $result = factory.createCase($scr.result, patterns, branches); }
|
cons=UIDENT { List<LamaExpressionNode> args = new ArrayList<>(); }
( '(' ex=expression[VAL] { args.add($ex.result); }
( ',' ex=expression[VAL] { args.add($ex.result); }
)*
')' )? { $result = factory.createSexp($cons.getText(), args); checkCategory(cat, VAL, $cons); }
|
c='{' { List<LamaExpressionNode> args = new ArrayList<>(); }
( ex=expression[VAL] { args.add($ex.result); }
( ',' ex=expression[VAL] { args.add($ex.result); }
)*
)? '}' { $result = factory.createList(new LamaLongLiteralNode(0), args);
         checkCategory(cat, VAL, $c); }
|
c='[' { List<LamaExpressionNode> args = new ArrayList<>(); }
( ex=expression[VAL] { args.add($ex.result); }
( ',' ex=expression[VAL] { args.add($ex.result); }
)*
)? ']' { $result = factory.createArray(args); checkCategory(cat, VAL, $c); }
|
f='fun' l=lambda_definition { $result = $l.result; checkCategory(cat, VAL, $f); }
|
'eta' fun=binary_expression[VOID] { $result = factory.createEta($fun.result); }
;

else_part[LamaSyntaxCategory cat] returns [LamaExpressionNode result]:
{ LamaExpressionNode elsePart = null; }
i='elif' cond=expression[VAL] 'then' body=scope_expression[cat, true]
(el=else_part[cat] { elsePart = $el.result; })?
{ $result = factory.createIf($i, $cond.result, $body.result, elsePart); }
|
'else' body=scope_expression[cat, true] { $result = $body.result; }
;

pattern returns [LamaPatternNode result]:
p=simple_pattern { $result = $p.result; }
|
{List<LamaPatternNode> subpatterns = new ArrayList<>(); }
(p=simple_pattern ':' { subpatterns.add($p.result); })+
p=simple_pattern { $result = factory.createConsPattern($p.result, subpatterns); }
;

simple_pattern returns [LamaPatternNode result]:
'_' { $result = new LamaSkipPatternNode(); }
|
UIDENT { List<LamaPatternNode> subpatterns = new ArrayList<>(); }
( '(' p=pattern { subpatterns.add($p.result); } (
  ',' p=pattern { subpatterns.add($p.result); }
)* ')' )? { $result = factory.createSexpPattern($UIDENT.getText(), subpatterns); }
|
'[' {List<LamaPatternNode> subpatterns = new ArrayList<>(); }
( p=pattern { subpatterns.add($p.result); } (
  ',' p=pattern { subpatterns.add($p.result); }
)*)? ']' { $result = factory.createArrayPattern(subpatterns); }
|
'{' {List<LamaPatternNode> subpatterns = new ArrayList<>(); }
( p=pattern { subpatterns.add($p.result); } (
  ',' p=pattern { subpatterns.add($p.result); }
)* )? '}' { $result = factory.createConsPattern(LamaIntegerPatternNodeGen.create(0), subpatterns); }
|
LIDENT { LamaPatternNode pat = new LamaSkipPatternNode(); }(
  '@' p=pattern { pat = $p.result; }
)? { $result = factory.createNamedPattern($LIDENT.getText(), pat); }
|
'true' { $result = LamaTruePatternNodeGen.create(); }
|
'false' { $result = LamaFalsePatternNodeGen.create(); }
|
'-' DECIMAL { $result = LamaIntegerPatternNodeGen.create(-Long.parseLong($DECIMAL.getText())); }
|
DECIMAL { $result = LamaIntegerPatternNodeGen.create(Long.parseLong($DECIMAL.getText())); }
|
STRING { $result = LamaStringPatternNodeGen.create(factory.trim($STRING.getText(), "\"")); }
|
CHAR { $result = LamaIntegerPatternNodeGen.create(factory.parseChar($CHAR)); }
|
'#' 'box' { $result = LamaBoxKindPatternNodeGen.create(); }
|
'#' 'val' { $result = LamaValKindPatternNodeGen.create(); }
|
'#' 'str' { $result = LamaStringKindPatternNodeGen.create(); }
|
'#' 'array' { $result = LamaArrayKindPatternNodeGen.create(); }
|
'#' 'sexp' { $result = LamaSexpKindPatternNodeGen.create(); }
|
'#' 'fun' { $result = LamaFunctionKindPatternNodeGen.create(); }
|
'(' pattern ')' { $result = $pattern.result; }
;

// lexer

WS : [ \t\r\n\u000C]+ -> skip;
COMMENT : '(*' .*? '*)' -> skip;
LINE_COMMENT : '--' ~[\r\n]* -> skip;

UIDENT : [A-Z][a-zA-Z_0-9]*;
LIDENT : [a-z][a-zA-Z_0-9]*;
DECIMAL : [0-9]+;
STRING : '"'(~["]|'""')*'"';
CHAR : '\''(~[']|'\''|'\n'|'\t')'\'';
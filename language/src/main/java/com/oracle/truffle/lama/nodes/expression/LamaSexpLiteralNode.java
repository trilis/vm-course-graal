package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.runtime.LamaSexp;

public class LamaSexpLiteralNode extends LamaExpressionNode {

    private final String constructorName;
    @Children private final LamaExpressionNode[] argNodes;

    public LamaSexpLiteralNode(String constructorName, LamaExpressionNode[] argNodes) {
        this.constructorName = constructorName;
        this.argNodes = argNodes;
    }

    @ExplodeLoop
    @Override
    public LamaSexp executeGeneric(VirtualFrame frame) {
        Object[] args = new Object[argNodes.length];
        CompilerAsserts.compilationConstant(argNodes.length);
        for (int i = 0; i < argNodes.length; i++) {
            args[i] = argNodes[i].executeGeneric(frame);
        }
        return new LamaSexp(constructorName, args);
    }
}

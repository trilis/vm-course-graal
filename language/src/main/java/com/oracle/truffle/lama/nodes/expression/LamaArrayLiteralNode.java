package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.runtime.LamaArray;
import com.oracle.truffle.lama.runtime.LamaSexp;

public class LamaArrayLiteralNode extends LamaExpressionNode {

    public LamaArrayLiteralNode(LamaExpressionNode[] argNodes) {
        this.argNodes = argNodes;
    }

    @Children private final LamaExpressionNode[] argNodes;

    @ExplodeLoop
    @Override
    public LamaArray executeGeneric(VirtualFrame frame) {
        Object[] args = new Object[argNodes.length];
        CompilerAsserts.compilationConstant(argNodes.length);
        for (int i = 0; i < argNodes.length; i++) {
            args[i] = argNodes[i].executeGeneric(frame);
        }
        return new LamaArray(args);
    }
}

package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.runtime.LamaNull;

public class LamaSkipNode extends LamaExpressionNode {

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return LamaNull.SINGLETON;
    }
}

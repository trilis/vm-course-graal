package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.lama.LamaLanguage;

public class LamaRootNode extends RootNode {

    @Child private LamaExpressionNode bodyNode;

    public LamaRootNode(LamaExpressionNode bodyNode,
                           FrameDescriptor frameDescriptor) {
        super(LamaLanguage.get(bodyNode), frameDescriptor);
        this.bodyNode = bodyNode;
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame virtualFrame) {
        return this.bodyNode.executeGeneric(virtualFrame);
    }

}

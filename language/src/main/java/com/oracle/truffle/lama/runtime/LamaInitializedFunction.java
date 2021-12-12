package com.oracle.truffle.lama.runtime;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.nodes.local.*;

public class LamaInitializedFunction {
    private final MaterializedFrame frame;
    public RootCallTarget callTarget;

    public LamaInitializedFunction(RootCallTarget callTarget, LamaExpressionNode[] readNodes, LamaWriteLocalNode[] writeNodes, FrameSlot[] slots, VirtualFrame oldFrame) {
        this.callTarget = callTarget;
        frame = Truffle.getRuntime().createMaterializedFrame(new Object[]{oldFrame.materialize()}, oldFrame.getFrameDescriptor());
        for (int i = 0; i < readNodes.length; i++) {
            Object value = readNodes[i].executeGeneric(oldFrame);
            writeNodes[i].executeWrite(frame, slots[i], value);
        }
    }

    public MaterializedFrame getFrame() {
        return this.frame;
    }
}

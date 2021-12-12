package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "writeLocal")
public abstract class LamaWriteLocalNode extends Node {

    public abstract Object executeWrite(Frame frame, FrameSlot slot, Object value);

    @Specialization(guards="isLongOrIllegal(frame, slot)")
    protected Object writeLocalLong(Frame frame, FrameSlot slot, long value) {
        frame.getFrameDescriptor().setFrameSlotKind(slot, FrameSlotKind.Long);
        frame.setLong(slot, value);
        return value;
    }

    @Fallback
    protected Object writeLocal(Frame frame, FrameSlot slot, Object value) {
        frame.getFrameDescriptor().setFrameSlotKind(slot, FrameSlotKind.Object);
        frame.setObject(slot, value);
        return value;
    }

    protected boolean isLongOrIllegal(Frame frame, FrameSlot slot) {
        final FrameSlotKind kind = frame.getFrameDescriptor().getFrameSlotKind(slot);
        return kind == FrameSlotKind.Long || kind == FrameSlotKind.Illegal;
    }
}

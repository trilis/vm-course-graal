package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameUtil;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.lama.LamaException;
import com.oracle.truffle.lama.runtime.LamaArrayRef;
import com.oracle.truffle.lama.runtime.LamaStringRef;

public abstract class LamaReaderHelperNode extends Node {
    public abstract Object executeRead(VirtualFrame frame, Object value);

    @Specialization
    protected Object readSlot(VirtualFrame frame, FrameSlot slot) {
        return FrameUtil.getObjectSafe(frame, slot);
    }

    @Specialization
    protected Object readArrayRef(LamaArrayRef ref) {
        return ref.get();
    }

    @Specialization
    protected Object readStringRef(LamaStringRef ref) {
        return ref.get();
    }

    @Fallback
    protected Object typeError(Object value) {
        throw LamaException.typeError(this, value);
    }
}

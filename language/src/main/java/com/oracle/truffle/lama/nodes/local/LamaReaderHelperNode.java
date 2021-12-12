package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.lama.LamaException;
import com.oracle.truffle.lama.runtime.LamaArrayRef;
import com.oracle.truffle.lama.runtime.LamaFunction;
import com.oracle.truffle.lama.runtime.LamaStringRef;

@NodeInfo(shortName = "readerHelper")
@NodeField(name = "skipFunctionInit", type = boolean.class)
public abstract class LamaReaderHelperNode extends Node {
    public abstract Object executeRead(VirtualFrame frame, Object value);

    protected abstract boolean isSkipFunctionInit();

    private Long tryReadLong(Frame frame, FrameSlot slot) {
        try {
            return frame.getLong(slot);
        } catch (Throwable e) {
            return null;
        }
    }

    @Specialization(guards="isLongOrIllegal(frame, slot)", rewriteOn = NullPointerException.class)
    protected long readSlotLong(VirtualFrame frame, FrameSlot slot) {
        Long value = tryReadLong(frame, slot);
        Frame currentFrame = frame;
        while (value == null && currentFrame.getArguments().length > 0) {
            currentFrame = (Frame) currentFrame.getArguments()[0];
            value = tryReadLong(currentFrame, slot);
        }
        return value;
    }

    @Specialization(rewriteOn = FrameSlotTypeException.class, replaces = {"readSlotLong"})
    protected Object readSlotObject(VirtualFrame frame, FrameSlot slot) throws FrameSlotTypeException {
        Object value = frame.getObject(slot);
        Frame currentFrame = frame;
        while (value == null && currentFrame.getArguments().length > 0) {
            currentFrame = (Frame) currentFrame.getArguments()[0];
            value = currentFrame.getObject(slot);
        }
        if (value instanceof LamaFunction && !isSkipFunctionInit()) {
            return ((LamaFunction) value).initialize(frame);
        }
        return value;
    }

    protected boolean isLongOrIllegal(Frame frame, FrameSlot slot) {
        final FrameSlotKind kind = frame.getFrameDescriptor().getFrameSlotKind(slot);
        return kind == FrameSlotKind.Long || kind == FrameSlotKind.Illegal;
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

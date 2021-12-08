package com.oracle.truffle.lama.runtime;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.interop.TruffleObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LamaPatternMatchingResult implements TruffleObject {
    public boolean isSuccessful;

    private final Map<FrameSlot, Object> bindings;

    private LamaPatternMatchingResult(boolean isSuccessful, Map<FrameSlot, Object> bindings) {
        this.isSuccessful = isSuccessful;
        this.bindings = bindings;
    }

    @TruffleBoundary
    public Set<Map.Entry<FrameSlot, Object>> getBindings() {
        return bindings.entrySet();
    }

    @TruffleBoundary
    public static LamaPatternMatchingResult Ok() {
        return new LamaPatternMatchingResult(true, new HashMap<>());
    }

    @TruffleBoundary
    public static LamaPatternMatchingResult Fail() {
        return new LamaPatternMatchingResult(false, new HashMap<>());
    }

    public void addBinding(FrameSlot slot, Object value) {
        bindings.put(slot, value);
    }

    @TruffleBoundary
    public LamaPatternMatchingResult mergeWith(LamaPatternMatchingResult other) {
        if (!isSuccessful) {
            return this;
        }
        if (!other.isSuccessful) {
            return other;
        }
        bindings.putAll(other.bindings);
        return this;
    }
}

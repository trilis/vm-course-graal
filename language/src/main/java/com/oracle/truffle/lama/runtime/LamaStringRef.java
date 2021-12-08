package com.oracle.truffle.lama.runtime;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.interop.TruffleObject;

public class LamaStringRef implements TruffleObject {
    private final StringBuffer string;
    private final int index;

    public LamaStringRef(StringBuffer string, long index) {
        this.string = string;
        this.index = (int) index;
    }

    @TruffleBoundary
    public void write(long value) {
        string.setCharAt(index, (char) value);
    }

    @TruffleBoundary
    public long get() {
        return string.charAt(index);
    }
}

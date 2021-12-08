package com.oracle.truffle.lama.runtime;

import com.oracle.truffle.api.interop.TruffleObject;

public class LamaArrayRef implements TruffleObject {
    private final LamaArray array;
    private final int index;

    public LamaArrayRef(LamaArray array, long index) {
        this.array = array;
        this.index = (int) index;
    }

    public Object get() {
        return array.getArg(index);
    }

    public void write(Object value) {
        array.setArg(index, value);
    }
}

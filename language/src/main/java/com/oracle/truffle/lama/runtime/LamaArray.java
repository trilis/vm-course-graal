package com.oracle.truffle.lama.runtime;

import com.oracle.truffle.api.interop.TruffleObject;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LamaArray implements TruffleObject {

    private final Object[] args;

    public LamaArray(Object[] args) {
        this.args = args;
    }

    public Object getArg(int i) {
        return args[i];
    }

    public void setArg(int i, Object value) {
        args[i] = value;
    }

    public long getLength() {
        return args.length;
    }

    @Override
    public String toString() {
        return "[" + Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", ")) + "]";
    }
}

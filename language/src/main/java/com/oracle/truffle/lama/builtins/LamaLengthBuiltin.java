package com.oracle.truffle.lama.builtins;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.lama.LamaException;
import com.oracle.truffle.lama.runtime.LamaArray;
import com.oracle.truffle.lama.runtime.LamaSexp;

@NodeInfo(shortName = "length")
public abstract class LamaLengthBuiltin extends LamaBuiltinNode {
    @Specialization
    public long length(LamaSexp value) {
        return value.getArgNum();
    }

    @Specialization
    public long length(LamaArray value) {
        return value.getLength();
    }

    @Specialization
    @TruffleBoundary
    public long length(StringBuffer value) {
        return value.length();
    }

    @Fallback
    protected Object typeError(Object value) {
        throw LamaException.typeError(this, value);
    }
}

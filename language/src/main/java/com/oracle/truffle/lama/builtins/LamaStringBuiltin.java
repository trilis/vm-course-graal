package com.oracle.truffle.lama.builtins;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.LamaException;
import com.oracle.truffle.lama.runtime.LamaArray;
import com.oracle.truffle.lama.runtime.LamaSexp;

public abstract class LamaStringBuiltin extends LamaBuiltinNode {

    @TruffleBoundary
    @Specialization
    protected StringBuffer stringLong(long value) {
        return new StringBuffer(String.valueOf(value));
    }

    @TruffleBoundary
    @Specialization
    protected StringBuffer stringBuffer(StringBuffer value) {
        return new StringBuffer("\"" + value + "\"");
    }

    @TruffleBoundary
    @Specialization
    protected StringBuffer stringArray(LamaArray value) {
        return new StringBuffer(value.toString());
    }

    @TruffleBoundary
    @Specialization
    protected StringBuffer stringSexp(LamaSexp value) {
        return new StringBuffer(value.toString());
    }

    @Fallback
    protected Object typeError(Object value) {
        throw LamaException.typeError(this, value);
    }

}

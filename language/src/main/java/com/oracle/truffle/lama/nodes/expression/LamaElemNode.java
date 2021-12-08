package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.lama.LamaException;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.runtime.LamaArray;
import com.oracle.truffle.lama.runtime.LamaSexp;

@NodeInfo(shortName = "[]")
@NodeChild("objectNode")
@NodeChild("indexNode")
public abstract class LamaElemNode extends LamaExpressionNode {

    @Specialization
    protected Object elemSexp(LamaSexp value, long i) {
        return value.getArg((int) i);
    }

    @Specialization
    protected Object elemArray(LamaArray value, long i) {
        return value.getArg((int) i);
    }

    @Specialization
    @TruffleBoundary
    protected long elemString(StringBuffer value, long i) {
        return value.charAt((int) i);
    }

    @Fallback
    protected Object typeError(Object value, Object i) {
        throw LamaException.typeError(this, value, i);
    }
}

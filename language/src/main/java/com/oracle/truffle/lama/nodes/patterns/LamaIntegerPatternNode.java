package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Fail;
import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Ok;

public abstract class LamaIntegerPatternNode extends LamaPatternNode {

    private final long n;

    public LamaIntegerPatternNode(long n) {
        this.n = n;
    }

    @Specialization
    protected LamaPatternMatchingResult matchLong(long scrutinee) {
        return scrutinee == n ? Ok() : Fail();
    }

    @Fallback
    protected LamaPatternMatchingResult matchError(Object scrutinee) {
        return Fail();
    }
}


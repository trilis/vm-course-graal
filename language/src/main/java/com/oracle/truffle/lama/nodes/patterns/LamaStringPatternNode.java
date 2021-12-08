package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.*;

public abstract class LamaStringPatternNode extends LamaPatternNode {

    private final StringBuffer expected;

    public LamaStringPatternNode(StringBuffer expected) {
        this.expected = expected;
    }

    @Specialization
    @TruffleBoundary
    protected LamaPatternMatchingResult matchString(StringBuffer actual) {
        return actual.toString().equals(expected.toString()) ? Ok() : Fail();
    }

    @Fallback
    protected LamaPatternMatchingResult matchString(Object actual) {
        return Fail();
    }
}

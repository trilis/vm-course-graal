package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;
import com.oracle.truffle.lama.runtime.LamaSexp;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Fail;
import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Ok;

public abstract class LamaSexpKindPatternNode extends LamaPatternNode {

    @Specialization
    protected LamaPatternMatchingResult matchSexp(LamaSexp ignored_) {
        return Ok();
    }

    @Fallback
    protected LamaPatternMatchingResult error(Object ignored_) {
        return Fail();
    }
}

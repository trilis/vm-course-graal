package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaArray;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;
import com.oracle.truffle.lama.runtime.LamaSexp;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Fail;
import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Ok;

public abstract class LamaBoxKindPatternNode extends LamaPatternNode {

    @Specialization
    protected LamaPatternMatchingResult matchArray(LamaArray ignored_) {
        return Ok();
    }

    @Specialization
    protected LamaPatternMatchingResult matchString(StringBuffer ignored_) {
        return Ok();
    }

    @Specialization
    protected LamaPatternMatchingResult matchSexp(LamaSexp ignored_) {
        return Ok();
    }

    @Fallback
    protected LamaPatternMatchingResult error(Object ignored_) {
        return Fail();
    }
}

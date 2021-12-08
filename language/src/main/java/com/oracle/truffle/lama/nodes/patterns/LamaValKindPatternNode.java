package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaArray;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Fail;
import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Ok;

public abstract class LamaValKindPatternNode extends LamaPatternNode {

    @Specialization
    protected LamaPatternMatchingResult matchLong(long ignored_) {
        return Ok();
    }

    @Fallback
    protected LamaPatternMatchingResult error(Object ignored_) {
        return Fail();
    }
}

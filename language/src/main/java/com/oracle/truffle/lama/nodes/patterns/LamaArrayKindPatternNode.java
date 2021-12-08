package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaArray;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.*;

public abstract class LamaArrayKindPatternNode extends LamaPatternNode {

    @Specialization
    protected LamaPatternMatchingResult matchArray(LamaArray ignored_) {
        return Ok();
    }

    @Fallback
    protected LamaPatternMatchingResult error(Object ignored_) {
        return Fail();
    }
}

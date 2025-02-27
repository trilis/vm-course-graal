package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaFunction;
import com.oracle.truffle.lama.runtime.LamaInitializedFunction;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Fail;
import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Ok;

public abstract class LamaFunctionKindPatternNode extends LamaPatternNode {

    @Specialization
    protected LamaPatternMatchingResult matchFunction(LamaFunction ignored_) {
        return Ok();
    }

    @Specialization
    protected LamaPatternMatchingResult matchInitializedFunction(LamaInitializedFunction ignored_) {
        return Ok();
    }

    @Fallback
    protected LamaPatternMatchingResult error(Object ignored_) {
        return Fail();
    }
}

package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.*;

@NodeInfo(shortName = "true")
public abstract class LamaTruePatternNode extends LamaPatternNode {

    @Specialization
    protected LamaPatternMatchingResult matchLong(long scrutinee) {
        return scrutinee != 0 ? Ok() : Fail();
    }

    @Fallback
    protected LamaPatternMatchingResult matchError(Object scrutinee) {
        return Fail();
    }
}

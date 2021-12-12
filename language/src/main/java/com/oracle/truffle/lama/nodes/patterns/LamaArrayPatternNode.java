package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.lama.runtime.LamaArray;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

import java.util.Arrays;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Fail;
import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Ok;

public abstract class LamaArrayPatternNode extends LamaPatternNode {

    public LamaArrayPatternNode(LamaPatternNode[] subpatterns) {
        this.subpatterns = subpatterns;
    }

    @Children private final LamaPatternNode[] subpatterns;

    @Specialization
    @ExplodeLoop
    protected LamaPatternMatchingResult matchArray(LamaArray array) {
        if (subpatterns.length != array.getLength()) {
            return Fail();
        }
        LamaPatternMatchingResult result = Ok();
        CompilerAsserts.compilationConstant(subpatterns.length);
        for (int i = 0; i < subpatterns.length; i++) {
            result = result.mergeWith(subpatterns[i].executeScrutinee(array.getArg(i)));
            if (!result.isSuccessful) {
                break;
            }
        }
        return result;
    }

    @Fallback
    protected LamaPatternMatchingResult matchError(Object ignored_) {
        return Fail();
    }

    @Override
    public int getBindingsSize() {
        return Arrays.stream(subpatterns).map(LamaPatternNode::getBindingsSize).reduce(0, Integer::sum);
    }
}

package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;
import com.oracle.truffle.lama.runtime.LamaSexp;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.*;

public abstract class LamaSexpPatternNode extends LamaPatternNode {

    private final String constructorName;
    @Children private final LamaPatternNode[] subpatterns;

    public LamaSexpPatternNode(String constructorName, LamaPatternNode[] subpatterns) {
        this.constructorName = constructorName;
        this.subpatterns = subpatterns;
    }

    @ExplodeLoop
    @Specialization
    protected LamaPatternMatchingResult matchSexp(LamaSexp scrutinee) {
        if (!constructorName.equals(scrutinee.getConstructorName()) || subpatterns.length != scrutinee.getArgNum()) {
            return Fail();
        }
        LamaPatternMatchingResult result = Ok();
        CompilerAsserts.compilationConstant(subpatterns.length);
        for (int i = 0; i < subpatterns.length; i++) {
            result = result.mergeWith(subpatterns[i].executeScrutinee(scrutinee.getArg(i)));
            if (!result.isSuccessful) {
                break;
            }
        }
        return result;
    }

    @Fallback
    protected LamaPatternMatchingResult matchError(Object scrutinee) {
        return Fail();
    }
}

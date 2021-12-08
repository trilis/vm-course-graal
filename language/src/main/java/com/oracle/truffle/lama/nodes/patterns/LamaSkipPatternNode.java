package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

import static com.oracle.truffle.lama.runtime.LamaPatternMatchingResult.Ok;

@NodeInfo(shortName = "_")
public class LamaSkipPatternNode extends LamaPatternNode {
    @Override
    public LamaPatternMatchingResult executeScrutinee(Object scrutinee) {
        return Ok();
    }
}

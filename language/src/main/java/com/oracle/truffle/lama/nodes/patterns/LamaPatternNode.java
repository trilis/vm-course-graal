package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

public abstract class LamaPatternNode extends Node {
    public abstract LamaPatternMatchingResult executeScrutinee(Object scrutinee);
}

package com.oracle.truffle.lama.nodes.patterns;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;

@NodeInfo(shortName = "@")
public class LamaNamedPatternNode extends LamaPatternNode {

    private final FrameSlot slot;
    @Child private LamaPatternNode pattern;

    public LamaNamedPatternNode(FrameSlot slot, LamaPatternNode pattern) {
        this.slot = slot;
        this.pattern = pattern;
    }

    @Override
    public LamaPatternMatchingResult executeScrutinee(Object scrutinee) {
        LamaPatternMatchingResult result = pattern.executeScrutinee(scrutinee);
        processResult(scrutinee, result);
        return result;
    }

    @TruffleBoundary
    private void processResult(Object scrutinee, LamaPatternMatchingResult result) {
        if (result.isSuccessful) {
            result.addBinding(slot, scrutinee);
        }
    }

    @Override
    public int getBindingsSize() {
        return pattern.getBindingsSize() + 1;
    }
}

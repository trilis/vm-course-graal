package com.oracle.truffle.lama.nodes.controlflow;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.lama.LamaException;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.nodes.local.LamaWriteLocalNode;
import com.oracle.truffle.lama.nodes.local.LamaWriteLocalNodeGen;
import com.oracle.truffle.lama.nodes.patterns.LamaPatternNode;
import com.oracle.truffle.lama.runtime.LamaPatternMatchingResult;
import org.graalvm.collections.Pair;

import java.util.Map;

@NodeInfo(shortName = "case")
public class LamaCaseNode extends LamaExpressionNode {

    @Child private LamaExpressionNode scrutineeNode;
    @Children private final LamaPatternNode[] patternNodes;
    @Children private final LamaExpressionNode[] branchNodes;
    @Children private final LamaWriteLocalNode[] writeNodes;

    public LamaCaseNode(LamaExpressionNode scrutineeNode, LamaPatternNode[] patternNodes, LamaExpressionNode[] branchNodes, int maximumBindingsSize) {
        this.scrutineeNode = scrutineeNode;
        this.patternNodes = patternNodes;
        this.branchNodes = branchNodes;
        this.writeNodes = new LamaWriteLocalNode[maximumBindingsSize];
        for (int i = 0; i < maximumBindingsSize; i++) {
            this.writeNodes[i] = LamaWriteLocalNodeGen.create();
        }
    }

    @ExplodeLoop
    @Override
    public Object executeGeneric(VirtualFrame frame) {
        Object scrutinee = scrutineeNode.executeGeneric(frame);
        CompilerAsserts.compilationConstant(patternNodes.length);
        int writeNodeNum = 0;
        for (int i = 0; i < patternNodes.length; i++) {
            LamaPatternMatchingResult result = patternNodes[i].executeScrutinee(scrutinee);
            if (result.isSuccessful) {
                FrameDescriptor descriptor = frame.getFrameDescriptor();
                /* cast to array to prevent throwing in Set */
                for (Pair<FrameSlot, Object> binding : extractBindings(result)) {
                    writeNodes[writeNodeNum++].executeWrite(frame, binding.getLeft(), binding.getRight());
                }
                return branchNodes[i].executeGeneric(frame);
            }
        }
        throw new LamaException("match failure", this);
    }

    @TruffleBoundary
    @SuppressWarnings("unchecked")
    private Pair<FrameSlot, Object>[] extractBindings(LamaPatternMatchingResult result) {
        return result.getBindings().stream().map((Map.Entry<FrameSlot, Object> e) -> Pair.create(e.getKey(), e.getValue())).toArray(Pair[]::new);
    }
}

package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import org.graalvm.compiler.nodeinfo.NodeInfo;

import java.util.ArrayList;
import java.util.List;

@NodeInfo(shortName = "promoteExternal")
public class LamaPromoteExternalWritesNode extends LamaExpressionNode {

    private final @Children LamaExpressionNode[] readNodes;
    private final @Children LamaWriteLocalNode[] writeNodes;
    private @Child LamaExpressionNode bodyNode;
    private final FrameSlot[] slots;

    public LamaPromoteExternalWritesNode(FrameSlot[] slots, LamaExpressionNode bodyNode) {
        this.slots = slots;
        readNodes = new LamaExpressionNode[slots.length];
        writeNodes = new LamaWriteLocalNode[slots.length];
        for (int i = 0; i < slots.length; i++) {
            readNodes[i] = LamaReadNodeGen.create(false, slots[i]);
            writeNodes[i] = LamaWriteLocalNodeGen.create();
        }
        this.bodyNode = bodyNode;
    }

    public Object executeGeneric(VirtualFrame frame) {
        Object result = bodyNode.executeGeneric(frame);
        List<Frame> parentFrames = new ArrayList<>();
        Frame currentFrame = frame;
        while (currentFrame.getArguments().length > 0) {
            currentFrame = (Frame) currentFrame.getArguments()[0];
            parentFrames.add(currentFrame);
        }
        Frame[] parentFramesArray = parentFrames.toArray(new Frame[0]);
        for (int i = 0; i < readNodes.length; i++) {
            Object value = readNodes[i].executeGeneric(frame);
            for (Frame parentFrame : parentFramesArray) {
                writeNodes[i].executeWrite(parentFrame, slots[i], value);
            }
        }
        return result;
    }
}

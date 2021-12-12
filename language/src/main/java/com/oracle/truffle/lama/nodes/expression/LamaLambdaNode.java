package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.runtime.LamaFunction;
import org.graalvm.compiler.nodeinfo.NodeInfo;

@NodeInfo(shortName = "lambda")
@NodeField(name = "function", type = LamaFunction.class)
public abstract class LamaLambdaNode extends LamaExpressionNode {
    public abstract LamaFunction getFunction();

    /* Lambdas are different from named functions, as they initialize their frames on creation */
    @Specialization
    public Object getLamaFunction(VirtualFrame virtualFrame) {
        return this.getFunction().initialize(virtualFrame);
    }

}

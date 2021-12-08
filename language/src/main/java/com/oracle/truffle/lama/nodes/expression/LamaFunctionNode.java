package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.runtime.LamaFunction;

@NodeField(name = "function", type = LamaFunction.class)
public abstract class LamaFunctionNode extends LamaExpressionNode {
    public abstract LamaFunction getFunction();

    @Specialization
    public Object getLamaFunction(VirtualFrame virtualFrame) {
        LamaFunction function = this.getFunction();
        function.setLexicalScope(virtualFrame.materialize());
        return function;
    }

}

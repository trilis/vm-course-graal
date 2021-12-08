package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.LamaException;
import com.oracle.truffle.lama.nodes.LamaExpressionNode;
import com.oracle.truffle.lama.nodes.local.LamaReaderHelperNode;
import com.oracle.truffle.lama.runtime.*;

@NodeChild("objectNode")
@NodeChild(value = "readerNode", executeWith = "objectNode", type = LamaReaderHelperNode.class)
@NodeChild("indexNode")
public abstract class LamaElemRefNode extends LamaExpressionNode {

    @Specialization
    protected Object elemRefArray(Object ignored_, LamaArray value, long index) {
        return new LamaArrayRef(value, index);
    }

    @Specialization
    protected Object elemRefString(Object ignored_, StringBuffer value, long index) {
        return new LamaStringRef(value, index);
    }

    @Fallback
    protected Object typeError(Object a, Object b, Object c) {
        throw LamaException.typeError(this, a, b, c);
    }
}

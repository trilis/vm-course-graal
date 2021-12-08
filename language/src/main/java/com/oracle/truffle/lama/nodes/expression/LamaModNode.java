package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.lama.LamaException;
import com.oracle.truffle.lama.nodes.LamaBinaryNode;

@NodeInfo(shortName = "%")
public abstract class LamaModNode extends LamaBinaryNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long mod(long left, long right) throws ArithmeticException {
        long result = left % right;
        /*
         * The division overflows if left is Long.MIN_VALUE and right is -1.
         */
        if (left == Long.MIN_VALUE && right == -1) {
            throw new ArithmeticException("long overflow");
        }
        return result;
    }

    @Fallback
    protected Object typeError(Object left, Object right) {
        throw LamaException.typeError(this, left, right);
    }

}

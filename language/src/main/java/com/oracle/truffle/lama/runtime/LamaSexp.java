package com.oracle.truffle.lama.runtime;

import com.oracle.truffle.api.interop.TruffleObject;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LamaSexp implements TruffleObject {
    private final String constructorName;
    private final Object[] args;

    public LamaSexp(String constructorName, Object[] args) {
        this.constructorName = constructorName;
        this.args = args;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public long getArgNum() {
        return args.length;
    }

    public Object getArg(int i) {
        return args[i];
    }

    @Override
    public String toString() {
        if (constructorName.equals("cons")) {
            StringBuilder result = new StringBuilder("{");
            LamaSexp sexp = this;
            result.append(args[0].toString());
            while (sexp.args[1] instanceof LamaSexp) {
                sexp = (LamaSexp) sexp.args[1];
                result.append(", ");
                result.append(sexp.args[0].toString());
            }
            return result + "}";
        }
        if (args.length == 0) {
            return constructorName;
        }
        return constructorName + " (" +
                Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", ")) + ")";
    }
}

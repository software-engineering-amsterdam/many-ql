package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.exceptions.UnsupportedArithmeticOperationException;

public abstract class Value {
    private final Object value;

    public Value and(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value or(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value add(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value sub(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value mul(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value div(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value mod(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value not() {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value eq(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value neq(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value lt(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value gt(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value lte(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Value gte(Value value) {
        throw new UnsupportedArithmeticOperationException();
    }

    public Object getValue() {
        return value;
    }

    public Value(Object value) {
        this.value = value;
    }

    public abstract void apply(TypeCallback typeCallback);

    @Override
    public String toString() {
        return "" + getValue();
    }
}

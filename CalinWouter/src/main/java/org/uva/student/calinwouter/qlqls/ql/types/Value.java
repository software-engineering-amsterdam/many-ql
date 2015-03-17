package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.exceptions.UnsupportedValueOperationException;

public abstract class Value {
    private final Object internalValue;

    public Value and(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Value or(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Value add(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Value sub(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Value mul(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Value div(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Value mod(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public BoolValue not() {
        throw new UnsupportedValueOperationException();
    }

    public BoolValue lt(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public BoolValue gt(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public BoolValue lte(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public BoolValue gte(Value value) {
        throw new UnsupportedValueOperationException();
    }

    Object getInternalValue() {
        return internalValue;
    }

    public Value(Object value) {
        assert(value != null);
        this.internalValue = value;
    }

    public BoolValue eq(Value value) {
        final Object otherInternalValue = value.getInternalValue();
        final Object myInternalValue = getInternalValue();
        final Boolean equality = otherInternalValue.equals(myInternalValue);
        return new BoolValue(equality);
    }

    public BoolValue neq(Value value) {
        final BoolValue equalityBoolValue = eq(value);
        return equalityBoolValue.not();
    }

    public abstract void apply(TypeCallback typeCallback);

    @Override
    public String toString() {
        return "" + getInternalValue();
    }
}

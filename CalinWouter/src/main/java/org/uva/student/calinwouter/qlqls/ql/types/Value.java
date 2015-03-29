package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeCallback;
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

    public Value subtract(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Value multiply(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Value divide(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Value modulo(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public BooleanValue not() {
        throw new UnsupportedValueOperationException();
    }

    public BooleanValue lesserThan(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public BooleanValue greaterThan(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public BooleanValue lesserThanOrEquals(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public BooleanValue greaterThanOrEquals(Value value) {
        throw new UnsupportedValueOperationException();
    }

    public Object toJavaObject() {
        return internalValue;
    }

    public Value(Object value) {
        assert(value != null);
        this.internalValue = value;
    }

    public BooleanValue valueEquals(Value value) {
        final Object otherInternalValue = value.toJavaObject();
        final Object myInternalValue = toJavaObject();
        final Boolean equality = otherInternalValue.equals(myInternalValue);
        return new BooleanValue(equality);
    }

    public BooleanValue valueNotEquals(Value value) {
        final BooleanValue equalityBooleanValue = valueEquals(value);
        return equalityBooleanValue.not();
    }

    public abstract void apply(ITypeCallback typeCallback);

    @Override
    public String toString() {
        return "" + toJavaObject();
    }
}

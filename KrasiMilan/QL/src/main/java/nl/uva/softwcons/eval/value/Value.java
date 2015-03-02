package nl.uva.softwcons.eval.value;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class Value {

    public abstract Object getValue();

    public Value add(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value subtract(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value multiply(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value divide(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isEqual(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isGreater(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isLower(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isGreaterOrEqual(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isLowerOrEqual(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue and(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue or(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue not() {
        throw new UnsupportedOperationException();
    }

    public BigInteger asInteger() {
        throw new UnsupportedOperationException();
    }

    public BigDecimal asDecimal() {
        throw new UnsupportedOperationException();
    }

    public String asString() {
        throw new UnsupportedOperationException();
    }

    public Boolean asBoolean() {
        throw new UnsupportedOperationException();
    }

}

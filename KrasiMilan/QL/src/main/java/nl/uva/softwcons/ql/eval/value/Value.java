package nl.uva.softwcons.ql.eval.value;

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

    public Value isEqual(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isGreater(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isLower(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isGreaterOrEqual(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isLowerOrEqual(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value and(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value or(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value not() {
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

    public abstract Value getValueFromString(String string);

    protected Value addNumber(NumberValue value) {
        throw new UnsupportedOperationException();
    }

    protected Value subtractNumber(NumberValue value) {
        throw new UnsupportedOperationException();
    }

    protected Value multiplyNumber(NumberValue value) {
        throw new UnsupportedOperationException();
    }

    protected Value divideNumber(NumberValue value) {
        throw new UnsupportedOperationException();
    }

    protected Value isGreaterNumber(NumberValue value) {
        throw new UnsupportedOperationException();
    }

    protected Value isGreaterOrEqualNumber(NumberValue value) {
        throw new UnsupportedOperationException();
    }

    protected Value isLowerNumber(NumberValue value) {
        throw new UnsupportedOperationException();
    }

    protected Value isLowerOrEqualNumber(NumberValue value) {
        throw new UnsupportedOperationException();
    }

    protected Value isEqualNumber(NumberValue value) {
        throw new UnsupportedOperationException();
    }

    protected Value andBoolean(BooleanValue otherValue) {
        throw new UnsupportedOperationException();
    }

    protected Value orBoolean(BooleanValue otherValue) {
        throw new UnsupportedOperationException();
    }

}

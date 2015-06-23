package nl.uva.softwcons.ql.eval.value;

import java.math.BigDecimal;

public abstract class Value {

    public boolean inConditionalContext() {
        throw new UnsupportedOperationException();
    }

    public BigDecimal getNumber() {
        throw new UnsupportedOperationException();
    }

    public String getString() {
        throw new UnsupportedOperationException();
    }

    public Boolean getBoolean() {
        throw new UnsupportedOperationException();
    }

    public Value add(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value subtract(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value multiply(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value divide(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isEqual(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isEqualBoolean(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isEqualString(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isGreater(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isLower(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isGreaterOrEqual(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value isLowerOrEqual(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value and(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value or(final Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value not() {
        throw new UnsupportedOperationException();
    }

    public Value addNumber(final NumberValue value) {
        throw new UnsupportedOperationException();
    }

    public Value subtractNumber(final NumberValue value) {
        throw new UnsupportedOperationException();
    }

    public Value multiplyNumber(final NumberValue value) {
        throw new UnsupportedOperationException();
    }

    public Value divideNumber(final NumberValue value) {
        throw new UnsupportedOperationException();
    }

    public Value isGreaterNumber(final NumberValue value) {
        throw new UnsupportedOperationException();
    }

    public Value isGreaterOrEqualNumber(final NumberValue value) {
        throw new UnsupportedOperationException();
    }

    public Value isLowerNumber(final NumberValue value) {
        throw new UnsupportedOperationException();
    }

    public Value isLowerOrEqualNumber(final NumberValue value) {
        throw new UnsupportedOperationException();
    }

    public Value isEqualNumber(final NumberValue value) {
        throw new UnsupportedOperationException();
    }

    public Value andBoolean(final BooleanValue otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value orBoolean(final BooleanValue otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value orUndefined() {
        throw new UnsupportedOperationException();
    }

}

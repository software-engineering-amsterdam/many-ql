package nl.uva.softwcons.ql.eval.value;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberValue extends Value {
    private final BigDecimal value;

    public NumberValue(int value) {
        this.value = new BigDecimal(value);
    }

    public NumberValue(double value) {
        this.value = new BigDecimal(value);
    }

    public NumberValue(final BigDecimal value) {
        this.value = value;
    }

    public NumberValue(final BigInteger value) {
        this.value = new BigDecimal(value);
    }

    @Override
    public BigDecimal getNumber() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Value add(final Value otherValue) {
        return otherValue.addNumber(this);
    }

    @Override
    public Value subtract(final Value otherValue) {
        return otherValue.subtractNumber(this);
    }

    @Override
    public Value multiply(final Value otherValue) {
        return otherValue.multiplyNumber(this);
    }

    @Override
    public Value divide(final Value otherValue) {
        return otherValue.divideNumber(this);
    }

    @Override
    public Value isEqual(final Value otherValue) {
        return otherValue.isEqualNumber(this);
    }

    @Override
    public Value isGreater(final Value otherValue) {
        return otherValue.isGreaterNumber(this);
    }

    @Override
    public Value isLower(final Value otherValue) {
        return otherValue.isLowerNumber(this);
    }

    @Override
    public Value isGreaterOrEqual(final Value otherValue) {
        return otherValue.isGreaterOrEqualNumber(this);
    }

    @Override
    public Value isLowerOrEqual(final Value otherValue) {
        return otherValue.isLowerNumber(this);
    }

    @Override
    public Value addNumber(final NumberValue otherValue) {
        return new NumberValue(this.value.add(otherValue.getNumber()));
    }

    @Override
    public Value subtractNumber(final NumberValue otherValue) {
        return new NumberValue(otherValue.getNumber().subtract(this.value));
    }

    @Override
    public Value multiplyNumber(final NumberValue otherValue) {
        return new NumberValue(this.value.multiply(otherValue.getNumber()));
    }

    @Override
    public Value divideNumber(final NumberValue otherValue) {
        return new NumberValue(otherValue.getNumber().divide(this.value));
    }

    @Override
    public BooleanValue isEqualNumber(final NumberValue otherValue) {
        return new BooleanValue(this.value.compareTo(otherValue.getNumber()) == 0);
    }

    @Override
    public BooleanValue isGreaterNumber(final NumberValue otherValue) {
        return new BooleanValue(otherValue.getNumber().compareTo(this.value) > 0);
    }

    @Override
    public BooleanValue isLowerNumber(final NumberValue otherValue) {
        return new BooleanValue(otherValue.getNumber().compareTo(this.value) < 0);
    }

    @Override
    public BooleanValue isGreaterOrEqualNumber(final NumberValue otherValue) {
        return new BooleanValue(otherValue.getNumber().compareTo(this.value) >= 0);
    }

    @Override
    public BooleanValue isLowerOrEqualNumber(final NumberValue otherValue) {
        return new BooleanValue(otherValue.getNumber().compareTo(this.value) <= 0);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NumberValue other = (NumberValue) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}

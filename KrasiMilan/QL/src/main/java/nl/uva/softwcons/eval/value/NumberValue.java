package nl.uva.softwcons.eval.value;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberValue extends Value {

    private final BigDecimal value;

    @Override
    public Number getValue() {
        return this.value;
    }

    public NumberValue(int value) {
        this.value = new BigDecimal(value);
    }

    public NumberValue(double value) {
        this.value = new BigDecimal(value);
    }

    public NumberValue(BigDecimal value) {
        this.value = value;
    }

    public NumberValue(BigInteger value) {
        this.value = new BigDecimal(value);
    }

    @Override
    public BigDecimal asDecimal() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Value add(Value otherValue) {
        return otherValue.addNumber(this);
    }

    @Override
    public Value subtract(Value otherValue) {
        return otherValue.subtractNumber(this);
    }

    @Override
    public Value multiply(Value otherValue) {
        return otherValue.multiplyNumber(this);
    }

    @Override
    public Value divide(Value otherValue) {
        return otherValue.divideNumber(this);
    }

    @Override
    public Value isEqual(Value otherValue) {
        return otherValue.isEqualNumber(this);
    }

    @Override
    public Value isGreater(Value otherValue) {
        return otherValue.isGreaterNumber(this);
    }

    @Override
    public Value isLower(Value otherValue) {
        return otherValue.isLowerNumber(this);
    }

    @Override
    public Value isGreaterOrEqual(Value otherValue) {
        return otherValue.isGreaterOrEqualNumber(this);
    }

    @Override
    public Value isLowerOrEqual(Value otherValue) {
        return otherValue.isLowerNumber(this);
    }

    @Override
    public Value getValueFromString(String string) {
        return new NumberValue(new BigDecimal(string));
    }

    @Override
    protected Value addNumber(NumberValue otherValue) {
        return new NumberValue(this.value.add(otherValue.asDecimal()));
    }

    @Override
    protected Value subtractNumber(NumberValue otherValue) {
        return new NumberValue(otherValue.asDecimal().subtract(this.value));
    }

    @Override
    protected Value multiplyNumber(NumberValue otherValue) {
        return new NumberValue(this.value.multiply(otherValue.asDecimal()));
    }

    @Override
    protected Value divideNumber(NumberValue otherValue) {
        return new NumberValue(otherValue.asDecimal().divide(this.value));
    }

    @Override
    protected BooleanValue isEqualNumber(NumberValue otherValue) {
        return new BooleanValue(this.value.compareTo(otherValue.asDecimal()) == 0);
    }

    @Override
    protected BooleanValue isGreaterNumber(NumberValue otherValue) {
        return new BooleanValue(otherValue.asDecimal().compareTo(this.value) > 0);
    }

    @Override
    protected BooleanValue isLowerNumber(NumberValue otherValue) {
        return new BooleanValue(otherValue.asDecimal().compareTo(this.value) < 0);
    }

    @Override
    protected BooleanValue isGreaterOrEqualNumber(NumberValue otherValue) {
        return new BooleanValue(otherValue.asDecimal().compareTo(this.value) >= 0);
    }

    @Override
    protected BooleanValue isLowerOrEqualNumber(NumberValue otherValue) {
        return new BooleanValue(otherValue.asDecimal().compareTo(this.value) <= 0);
    }
}

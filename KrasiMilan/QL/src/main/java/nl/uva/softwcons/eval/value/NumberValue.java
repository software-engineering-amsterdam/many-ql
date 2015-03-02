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
    public NumberValue add(Value otherValue) {
        return new NumberValue(this.value.add(otherValue.asDecimal()));
    }

    @Override
    public NumberValue subtract(Value otherValue) {
        return new NumberValue(this.value.subtract(otherValue.asDecimal()));
    }

    @Override
    public NumberValue multiply(Value otherValue) {
        return new NumberValue(this.value.multiply(otherValue.asDecimal()));
    }

    @Override
    public NumberValue divide(Value otherValue) {
        return new NumberValue(this.value.divide(otherValue.asDecimal()));
    }

    @Override
    public BooleanValue isEqual(Value otherValue) {
        return new BooleanValue(this.value.compareTo(otherValue.asDecimal()) == 0);
    }

    @Override
    public BooleanValue isGreater(Value otherValue) {
        return new BooleanValue(this.value.compareTo(otherValue.asDecimal()) > 0);
    }

    @Override
    public BooleanValue isLower(Value otherValue) {
        return new BooleanValue(this.value.compareTo(otherValue.asDecimal()) < 0);
    }

    @Override
    public BooleanValue isGreaterOrEqual(Value otherValue) {
        return new BooleanValue(this.value.compareTo(otherValue.asDecimal()) >= 0);
    }

    @Override
    public BooleanValue isLowerOrEqual(Value otherValue) {
        return new BooleanValue(this.value.compareTo(otherValue.asDecimal()) <= 0);
    }

    @Override
    public Value getValueFromString(String string) {
        return new NumberValue(new BigDecimal(string));
    }
}

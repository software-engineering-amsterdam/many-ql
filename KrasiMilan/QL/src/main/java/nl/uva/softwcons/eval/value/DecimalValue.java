package nl.uva.softwcons.eval.value;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DecimalValue extends Value {

    private final BigDecimal value;

    @Override
    public Number getValue() {
        return this.value;
    }

    public BigDecimal getDecimalValue() {
        return this.value;
    }

    public DecimalValue(BigDecimal value) {
        this.value = value;
    }

    public DecimalValue(BigInteger value) {
        this.value = new BigDecimal(value);
    }

    public DecimalValue(int value) {
        this.value = new BigDecimal(value);
    }

    @Override
    public BigDecimal asDecimal() {
        return value;
    }

    @Override
    public String asString() {
        return value.toString();
    }

    @Override
    public DecimalValue add(Value otherValue) {
        return new DecimalValue(this.value.add(((DecimalValue) otherValue).getDecimalValue()));
    }

    @Override
    public DecimalValue subtract(Value otherValue) {
        return new DecimalValue(this.value.subtract(((DecimalValue) otherValue).getDecimalValue()));
    }

    @Override
    public DecimalValue multiply(Value otherValue) {
        return new DecimalValue(this.value.multiply(((DecimalValue) otherValue).getDecimalValue()));
    }

    @Override
    public DecimalValue divide(Value otherValue) {
        return new DecimalValue(this.value.divide(((DecimalValue) otherValue).getDecimalValue()));
    }

    @Override
    public BooleanValue isEqual(Value otherValue) {
        return new BooleanValue(this.value.compareTo(((DecimalValue) otherValue).getDecimalValue()) == 0);
    }

    @Override
    public BooleanValue isGreater(Value otherValue) {
        return new BooleanValue(this.value.compareTo(((DecimalValue) otherValue).getDecimalValue()) > 0);
    }

    @Override
    public BooleanValue isLower(Value otherValue) {
        return new BooleanValue(this.value.compareTo(((DecimalValue) otherValue).getDecimalValue()) < 0);
    }

    @Override
    public BooleanValue isGreaterOrEqual(Value otherValue) {
        return new BooleanValue(this.value.compareTo(((DecimalValue) otherValue).getDecimalValue()) >= 0);
    }

    @Override
    public BooleanValue isLowerOrEqual(Value otherValue) {
        return new BooleanValue(this.value.compareTo(((DecimalValue) otherValue).getDecimalValue()) <= 0);
    }

    protected DecimalValue addInt(IntegerValue value) {
        return this.add(value);
    }

    protected DecimalValue subInt(IntegerValue value) {
        return new DecimalValue(value.getDecimalValue().subtract(this.value));
    }

    protected DecimalValue mulInt(IntegerValue value) {
        return this.multiply(value);
    }

    protected DecimalValue divInt(IntegerValue value) {
        return new DecimalValue(value.getDecimalValue().divide(this.value));
    }
}

package nl.uva.softwcons.eval.value;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DecimalValue extends Value {

    private final BigDecimal decimalValue;

    public DecimalValue(BigDecimal value) {
        this.decimalValue = value;
    }

    public DecimalValue(BigInteger value) {
        this.decimalValue = new BigDecimal(value);
    }

    public BigDecimal getDecimalValue() {
        return this.decimalValue;
    }

    @Override
    public BigDecimal getValue() {
        return getDecimalValue();
    }

    public DecimalValue add(DecimalValue otherValue) {
        return new DecimalValue(this.decimalValue.add(otherValue.getDecimalValue()));
    }

    public DecimalValue subtract(DecimalValue otherValue) {
        return new DecimalValue(this.decimalValue.subtract(otherValue.getDecimalValue()));
    }

    public DecimalValue multiply(DecimalValue otherValue) {
        return new DecimalValue(this.decimalValue.multiply(otherValue.getDecimalValue()));
    }

    public DecimalValue divide(DecimalValue otherValue) {
        return new DecimalValue(this.decimalValue.divide(otherValue.getDecimalValue()));
    }

    public BooleanValue isGreater(DecimalValue otherValue) {
        return new BooleanValue(this.decimalValue.compareTo(otherValue.getDecimalValue()) == 1);
    }

    public BooleanValue isGreaterOrEqual(DecimalValue otherValue) {
        return new BooleanValue(this.decimalValue.compareTo(otherValue.getDecimalValue()) >= 0);
    }

    public BooleanValue isLowerOrEqual(DecimalValue otherValue) {
        return new BooleanValue(this.decimalValue.compareTo(otherValue.getDecimalValue()) <= 0);
    }

    public BooleanValue isLower(DecimalValue otherValue) {
        return new BooleanValue(this.decimalValue.compareTo(otherValue.getDecimalValue()) < 0);

    }

    @Override
    public BooleanValue isEqual(Value otherValue) {
        return new BooleanValue(this.decimalValue.compareTo(((DecimalValue) otherValue).getDecimalValue()) == 0);
    }
}

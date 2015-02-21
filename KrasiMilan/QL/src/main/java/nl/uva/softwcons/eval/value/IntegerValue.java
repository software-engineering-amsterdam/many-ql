package nl.uva.softwcons.eval.value;

import java.math.BigInteger;

public class IntegerValue extends DecimalValue {

    private final BigInteger integerValue;

    public IntegerValue(BigInteger value) {
        super(value);
        this.integerValue = value;
    }

    public BigInteger getIntegerValue() {
        return this.integerValue;
    }

    // @Override
    // public BigInteger getValue() {
    // return getIntegerValue();
    // }

    public IntegerValue add(IntegerValue otherValue) {
        return new IntegerValue(this.integerValue.add(otherValue.getIntegerValue()));
    }

    public IntegerValue subtract(IntegerValue otherValue) {
        return new IntegerValue(this.integerValue.subtract(otherValue.getIntegerValue()));
    }

    public IntegerValue multiply(IntegerValue otherValue) {
        return new IntegerValue(this.integerValue.multiply(otherValue.getIntegerValue()));
    }

    public IntegerValue divide(IntegerValue otherValue) {
        return new IntegerValue(this.integerValue.divide(otherValue.getIntegerValue()));
    }
}

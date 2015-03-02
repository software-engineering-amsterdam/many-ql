package nl.uva.softwcons.eval.value;

import java.math.BigInteger;

public class IntegerValue extends DecimalValue {

    private final BigInteger value;

    public IntegerValue(BigInteger value) {
        super(value);
        this.value = value;
    }

    public IntegerValue(int value) {
        super(BigInteger.valueOf(value));
        BigInteger bigValue = BigInteger.valueOf(value);
        this.value = bigValue;
    }

    @Override
    public BigInteger asInteger() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Number getValue() {
        return value;
    }

    @Override
    public DecimalValue add(Value otherValue) {
        return ((DecimalValue) otherValue).addInt(this);
    }

    @Override
    public DecimalValue subtract(Value otherValue) {
        return ((DecimalValue) otherValue).subInt(this);
    }

    @Override
    public DecimalValue multiply(Value otherValue) {
        return ((DecimalValue) otherValue).mulInt(this);
    }

    @Override
    public DecimalValue divide(Value otherValue) {
        return ((DecimalValue) otherValue).divInt(this);
    }

    @Override
    public Value getValueFromString(String string) {
        return new IntegerValue(Integer.parseInt(string));
    }

    protected IntegerValue addInt(IntegerValue otherValue) {
        return new IntegerValue(this.value.add(otherValue.asInteger()));
    }

    protected IntegerValue subInt(IntegerValue otherValue) {
        return new IntegerValue((otherValue.asInteger()).subtract(this.value));
    }

    protected IntegerValue mulInt(IntegerValue otherValue) {
        return new IntegerValue((otherValue.asInteger()).multiply(this.value));
    }

    protected IntegerValue divInt(IntegerValue otherValue) {
        return new IntegerValue((otherValue.asInteger()).divide(this.value));
    }

}

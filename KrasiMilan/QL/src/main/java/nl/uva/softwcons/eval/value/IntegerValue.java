package nl.uva.softwcons.eval.value;

import java.math.BigInteger;

public class IntegerValue extends DecimalValue {

    private final BigInteger value;

    public IntegerValue(BigInteger value) {
        super(value);
        this.value = value;
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
        return ((IntegerValue) otherValue).divInt(this);
    }

    protected IntegerValue addInt(IntegerValue otherValue) {
        return new IntegerValue(this.value.add((BigInteger) otherValue.getValue()));
    }

    protected IntegerValue subInt(IntegerValue otherValue) {
        return new IntegerValue(((BigInteger) otherValue.getValue()).subtract(this.value));
    }

    protected IntegerValue mulInt(IntegerValue otherValue) {
        return new IntegerValue(((BigInteger) otherValue.getValue()).multiply(this.value));
    }

    protected IntegerValue divInt(IntegerValue otherValue) {
        return new IntegerValue(((BigInteger) otherValue.getValue()).divide(this.value));
    }

}

package nl.uva.softwcons.eval.value;

public class StringValue extends Value {

    String stringValue;

    public StringValue(String value) {
        this.stringValue = value;
    }

    @Override
    public Object getValue() {
        return this.stringValue;
    }

    @Override
    public BooleanValue isEqual(Value otherValue) {
        return new BooleanValue(this.stringValue.equals(((StringValue) otherValue).getValue()));
    }
}

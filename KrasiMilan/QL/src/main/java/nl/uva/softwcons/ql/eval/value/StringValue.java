package nl.uva.softwcons.ql.eval.value;

public class StringValue extends Value {
    private final String value;

    public StringValue(final String value) {
        this.value = value;
    }

    @Override
    public String getString() {
        return value;
    }

    @Override
    public Value isEqual(final Value otherValue) {
        return otherValue.isEqualString(this);
    }

    @Override
    public Value isEqualString(final Value otherValue) {
        return new BooleanValue(this.value.equals(otherValue.getString()));
    }

}

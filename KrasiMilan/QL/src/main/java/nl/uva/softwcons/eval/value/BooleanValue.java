package nl.uva.softwcons.eval.value;

public class BooleanValue extends Value {

    private final Boolean value;

    public BooleanValue(boolean literal) {
        this.value = literal;
    }

    @Override
    public Boolean getValue() {
        return this.value;
    }

    @Override
    public Boolean asBoolean() {
        return value;
    }

    @Override
    public String asString() {
        return value.toString();
    }

    @Override
    public Value isEqual(Value otherValue) {
        return new BooleanValue(this.value.equals(otherValue.asBoolean()));
    }

    @Override
    public Value and(Value otherValue) {
        return otherValue.andBoolean(this);
    }

    @Override
    public Value or(Value otherValue) {
        return otherValue.orBoolean(this);
    }

    @Override
    public Value not() {
        return new BooleanValue(!this.value);
    }

    @Override
    public Value getValueFromString(String string) {
        return new BooleanValue(Boolean.valueOf(string));
    }

    @Override
    protected Value andBoolean(BooleanValue otherValue) {
        return new BooleanValue(this.value && otherValue.asBoolean());
    }

    @Override
    protected Value orBoolean(BooleanValue otherValue) {
        return new BooleanValue(this.value || otherValue.asBoolean());
    }

}

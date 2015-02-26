package nl.uva.softwcons.eval.value;

public class BooleanValue extends Value<Boolean> {

    private final Boolean value;

    public BooleanValue(boolean literal) {
        this.value = literal;
    }

    @Override
    public Boolean getValue() {
        return this.value;
    }

    @Override
    public BooleanValue isEqual(Value otherValue) {
        return new BooleanValue(this.value != null && (this.value == ((Boolean) otherValue.getValue())));
    }

    @Override
    public BooleanValue and(Value otherValue) {
        return new BooleanValue(this.value && (Boolean) otherValue.getValue());
    }

    @Override
    public BooleanValue or(Value otherValue) {
        return new BooleanValue(this.value || (Boolean) otherValue.getValue());
    }

    @Override
    public BooleanValue not() {
        return new BooleanValue(!this.value);
    }

}

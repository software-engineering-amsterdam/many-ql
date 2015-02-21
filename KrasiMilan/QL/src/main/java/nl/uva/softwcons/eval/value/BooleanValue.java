package nl.uva.softwcons.eval.value;

public class BooleanValue extends Value {

    private boolean value;

    public BooleanValue(boolean literal) {
        this.value = literal;
    }

    @Override
    public Boolean getValue() {
        return this.value;
    }

    @Override
    public BooleanValue isEqual(Value otherValue) {
        return new BooleanValue(this.value == ((BooleanValue) otherValue).getValue());
    }

    public BooleanValue and(BooleanValue otherValue) {
        return new BooleanValue(this.value && otherValue.getValue());
    }

    public BooleanValue or(BooleanValue otherValue) {
        return new BooleanValue(this.value || otherValue.getValue());
    }

    public BooleanValue not() {
        return new BooleanValue(!this.value);
    }

}

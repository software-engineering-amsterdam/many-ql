package nl.uva.softwcons.ql.eval.value;

public class BooleanValue extends Value {
    private final Boolean value;

    public BooleanValue(final boolean literal) {
        this.value = literal;
    }

    @Override
    public boolean inConditionalContext() {
        return this.value;
    }

    @Override
    public Boolean getBoolean() {
        return value;
    }

    @Override
    public Value isEqual(final Value otherValue) {
        return otherValue.isEqualBoolean(this);
    }

    @Override
    public Value and(final Value otherValue) {
        return otherValue.andBoolean(this);
    }

    @Override
    public Value or(final Value otherValue) {
        return otherValue.orBoolean(this);
    }

    @Override
    public Value not() {
        return new BooleanValue(!this.value);
    }

    @Override
    public Value andBoolean(final BooleanValue otherValue) {
        return new BooleanValue(this.value && otherValue.getBoolean());
    }

    @Override
    public Value orBoolean(final BooleanValue otherValue) {
        return new BooleanValue(this.value || otherValue.getBoolean());
    }

    @Override
    public Value isEqualBoolean(final Value otherValue) {
        return new BooleanValue(this.value.equals(otherValue.getBoolean()));
    }

}

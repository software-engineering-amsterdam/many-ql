package nl.uva.softwcons.ql.eval.value;

public final class UndefinedValue extends Value {
    public static final UndefinedValue UNDEFINED = new UndefinedValue();

    private UndefinedValue() {
    }

    @Override
    public boolean inConditionalContext() {
        return false;
    }

    @Override
    public Value add(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value subtract(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value multiply(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value divide(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isEqual(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isEqualBoolean(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isEqualString(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isGreater(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isLower(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isGreaterOrEqual(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isLowerOrEqual(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value and(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value or(final Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value not() {
        return UNDEFINED;
    }

    @Override
    public Value addNumber(final NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value subtractNumber(final NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value multiplyNumber(final NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value divideNumber(final NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isEqualNumber(final NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isGreaterNumber(final NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isLowerNumber(final NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isGreaterOrEqualNumber(final NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isLowerOrEqualNumber(final NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value andBoolean(final BooleanValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value orBoolean(final BooleanValue otherValue) {
        return UNDEFINED;
    }

    @Override
    public String toString() {
        return "";
    }
}

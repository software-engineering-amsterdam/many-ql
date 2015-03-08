package nl.uva.softwcons.ql.eval.value;

public class UndefinedValue extends Value {
    public static UndefinedValue UNDEFINED = new UndefinedValue();

    private UndefinedValue() {
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public Value getValueFromString(String string) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Value add(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value subtract(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value multiply(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value divide(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isEqual(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isGreater(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isLower(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isGreaterOrEqual(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value isLowerOrEqual(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value and(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value or(Value otherValue) {
        return UNDEFINED;
    }

    @Override
    public Value not() {
        return UNDEFINED;
    }

    @Override
    protected Value addNumber(NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value subtractNumber(NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value multiplyNumber(NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value divideNumber(NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value isEqualNumber(NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value isGreaterNumber(NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value isLowerNumber(NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value isGreaterOrEqualNumber(NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value isLowerOrEqualNumber(NumberValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value andBoolean(BooleanValue otherValue) {
        return UNDEFINED;
    }

    @Override
    protected Value orBoolean(BooleanValue otherValue) {
        return UNDEFINED;
    }

}

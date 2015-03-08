package nl.uva.softwcons.eval.value;

public class UndefinedValue extends Value {

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
        return new UndefinedValue();
    }

    @Override
    public Value subtract(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value multiply(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value divide(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value isEqual(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value isGreater(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value isLower(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value isGreaterOrEqual(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value isLowerOrEqual(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value and(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value or(Value otherValue) {
        return new UndefinedValue();
    }

    @Override
    public Value not() {
        return new UndefinedValue();
    }

    @Override
    protected Value addNumber(NumberValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value subtractNumber(NumberValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value multiplyNumber(NumberValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value divideNumber(NumberValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value isEqualNumber(NumberValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value isGreaterNumber(NumberValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value isLowerNumber(NumberValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value isGreaterOrEqualNumber(NumberValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value isLowerOrEqualNumber(NumberValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value andBoolean(BooleanValue otherValue) {
        return new UndefinedValue();
    }

    @Override
    protected Value orBoolean(BooleanValue otherValue) {
        return new UndefinedValue();
    }

}

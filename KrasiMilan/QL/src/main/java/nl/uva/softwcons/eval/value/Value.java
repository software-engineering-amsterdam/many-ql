package nl.uva.softwcons.eval.value;

public abstract class Value<T> {

    public abstract T getValue();

    public Value add(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value subtract(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value multiply(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public Value divide(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isEqual(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isGreater(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isLower(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isGreaterOrEqual(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue isLowerOrEqual(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue and(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue or(Value otherValue) {
        throw new UnsupportedOperationException();
    }

    public BooleanValue not() {
        throw new UnsupportedOperationException();
    }
}

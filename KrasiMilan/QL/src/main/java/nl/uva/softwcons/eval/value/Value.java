package nl.uva.softwcons.eval.value;

public abstract class Value {

    public abstract Object getValue();

    public abstract BooleanValue isEqual(Value otherValue);
}

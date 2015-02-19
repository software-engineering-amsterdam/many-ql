package org.fugazi.evaluator;

public abstract class ExpressionValue<T> {

    protected final T value;
    
    ExpressionValue(T _value) {
        this.value = _value;
    }

    public T getValue() {
        return this.value;
    }

    public ExpressionValue add(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }
    
    public ExpressionValue addInt(IntValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }
    
    public ExpressionValue addString(StringValue exprValue) {
        // TODO: throw UndefinedExpeption?
       return null;     
    }

    public ExpressionValue sub(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue subInt(IntValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue mul(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue mulInt(IntValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue div(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue divInt(IntValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }
    
    public ExpressionValue and(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue or(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue not() {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }
    
    public ExpressionValue negative() {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue positive() {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public BoolValue equal(ExpressionValue exprValue) {
        return new BoolValue(this.value == exprValue.getValue());
    }

    public BoolValue notEqual(ExpressionValue exprValue) {
        return new BoolValue(this.value != exprValue.getValue());
    }

    public ExpressionValue greater(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue greaterInt(IntValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }
    
    public ExpressionValue less(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue lessInt(IntValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }
    
    public ExpressionValue greaterEqual(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue greaterEqualInt(IntValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }
    
    public ExpressionValue lessEqual(ExpressionValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }

    public ExpressionValue lessEqualInt(IntValue exprValue) {
        // TODO: throw UndefinedExpeption?
        return new UndefinedValue();
    }
}

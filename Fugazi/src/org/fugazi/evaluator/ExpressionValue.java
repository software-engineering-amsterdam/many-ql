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
}

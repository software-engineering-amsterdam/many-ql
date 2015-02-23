package org.fugazi.evaluator.expression_value;

public abstract class ExpressionValue<T> {

    protected final T value;
    
    ExpressionValue(T _value) {
        this.value = _value;
    }

    public T getValue() {
        return this.value;
    }
    
    public boolean isNull() {
        return false;
    }

    public ExpressionValue add(ExpressionValue exprValue) {
        return new UndefinedValue();
    }
    
    public ExpressionValue addInt(IntValue exprValue) {
        return new UndefinedValue();
    }
    
    public ExpressionValue addString(StringValue exprValue) {
       return new UndefinedValue();
    }

    public ExpressionValue sub(ExpressionValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue subInt(IntValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue mul(ExpressionValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue mulInt(IntValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue div(ExpressionValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue divInt(IntValue exprValue) {
        return new UndefinedValue();
    }
    
    public ExpressionValue and(ExpressionValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue andBool(BoolValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue or(ExpressionValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue orBool(BoolValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue not() {
        return new UndefinedValue();
    }
    
    public ExpressionValue negative() {
        return new UndefinedValue();
    }

    public ExpressionValue positive() {
        return new UndefinedValue();
    }

    public BoolValue equal(ExpressionValue exprValue) {
        return new BoolValue(this.value == exprValue.getValue());
    }

    public BoolValue notEqual(ExpressionValue exprValue) {
        return new BoolValue(this.value != exprValue.getValue());
    }

    public ExpressionValue greater(ExpressionValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue greaterInt(IntValue exprValue) {
        return new UndefinedValue();
    }
    
    public ExpressionValue less(ExpressionValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue lessInt(IntValue exprValue) {
        return new UndefinedValue();
    }
    
    public ExpressionValue greaterEqual(ExpressionValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue greaterEqualInt(IntValue exprValue) {
        return new UndefinedValue();
    }
    
    public ExpressionValue lessEqual(ExpressionValue exprValue) {
        return new UndefinedValue();
    }

    public ExpressionValue lessEqualInt(IntValue exprValue) {
        return new UndefinedValue();
    }
}
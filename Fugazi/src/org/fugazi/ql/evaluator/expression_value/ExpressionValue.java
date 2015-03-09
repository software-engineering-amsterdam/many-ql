package org.fugazi.ql.evaluator.expression_value;

public abstract class ExpressionValue<T> {

    protected final T value;
    
    ExpressionValue(T _value) {
        this.value = _value;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isUndefined() {
        return false;
    }

    public ExpressionValue add(ExpressionValue exprValue) {
        throw new AssertionError();
    }
    
    public ExpressionValue addInt(IntValue exprValue) {
        throw new AssertionError();
    }
    
    public ExpressionValue addString(StringValue exprValue) {
       throw new AssertionError();
    }

    public ExpressionValue sub(ExpressionValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue subInt(IntValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue mul(ExpressionValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue mulInt(IntValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue div(ExpressionValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue divInt(IntValue exprValue) {
        throw new AssertionError();
    }
    
    public ExpressionValue and(ExpressionValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue andBool(BoolValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue or(ExpressionValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue orBool(BoolValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue not() {
        throw new AssertionError();
    }
    
    public ExpressionValue negative() {
        throw new AssertionError();
    }

    public ExpressionValue positive() {
        throw new AssertionError();
    }

    public BoolValue equal(ExpressionValue exprValue) {
        return new BoolValue(this.value == exprValue.getValue());
    }

    public BoolValue notEqual(ExpressionValue exprValue) {
        return new BoolValue(this.value != exprValue.getValue());
    }

    public ExpressionValue greater(ExpressionValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue greaterInt(IntValue exprValue) {
        throw new AssertionError();
    }
    
    public ExpressionValue less(ExpressionValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue lessInt(IntValue exprValue) {
        throw new AssertionError();
    }
    
    public ExpressionValue greaterEqual(ExpressionValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue greaterEqualInt(IntValue exprValue) {
        throw new AssertionError();
    }
    
    public ExpressionValue lessEqual(ExpressionValue exprValue) {
        throw new AssertionError();
    }

    public ExpressionValue lessEqualInt(IntValue exprValue) {
        throw new AssertionError();
    }
}
package org.fugazi.ql.evaluator.expression_value;

public class UndefinedValue extends ExpressionValue {

    public UndefinedValue() {
        super(null);
    }

    @Override
    public boolean isUndefined() {
        return true;
    }

    @Override
    public ExpressionValue add(ExpressionValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue addInt(IntValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue addString(StringValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue sub(ExpressionValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue subInt(IntValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue mul(ExpressionValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue mulInt(IntValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue div(ExpressionValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue divInt(IntValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue and(ExpressionValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue andBool(BoolValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue or(ExpressionValue exprValue) {
        return this;
    }
    
    @Override
    public ExpressionValue orBool(BoolValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue not() {
        return this;
    }

    @Override
    public ExpressionValue negative() {
        return this;
    }

    @Override
    public ExpressionValue positive() {
        return this;
    }

    @Override
    public BoolValue equal(ExpressionValue exprValue) {
        return new BoolValue(this.getValue()  == exprValue.getValue());
    }

    @Override
    public BoolValue notEqual(ExpressionValue exprValue) {
        return new BoolValue(this.getValue()  != exprValue.getValue());
    }

    @Override
    public ExpressionValue greater(ExpressionValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue greaterInt(IntValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue less(ExpressionValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue lessInt(IntValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue greaterEqual(ExpressionValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue greaterEqualInt(IntValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue lessEqual(ExpressionValue exprValue) {
        return this;
    }

    @Override
    public ExpressionValue lessEqualInt(IntValue exprValue) {
        return this;
    }
}

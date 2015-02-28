package org.fugazi.evaluator.expression_value;

public class BoolValue extends ExpressionValue<Boolean> {

    public BoolValue(Boolean _value) {
        super(_value);
    }

    @Override
    public ExpressionValue and(ExpressionValue exprValue) {
        return exprValue.andBool(this);
    }

    @Override
    public ExpressionValue andBool(BoolValue exprValue) {
        return new BoolValue(this.value && exprValue.getValue());
    }

    @Override
    public ExpressionValue or(ExpressionValue exprValue) {
        return exprValue.orBool(this);
    }

    @Override
    public ExpressionValue orBool(BoolValue exprValue) {
        return new BoolValue(this.value || exprValue.getValue());
    }

    @Override
    public ExpressionValue not() {
        return new BoolValue( !this.value );
    }
}
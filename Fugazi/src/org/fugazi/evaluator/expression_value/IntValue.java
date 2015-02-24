package org.fugazi.evaluator.expression_value;

public class IntValue extends ExpressionValue<Integer> {

    public IntValue(Integer _value) {
        super(_value);
    }

    /**
     * Add
     */
    @Override
    public ExpressionValue add(ExpressionValue exprValue) {
        return exprValue.addInt(this);
    }

    @Override
    public ExpressionValue addInt(IntValue exprValue) {
        return new IntValue(this.value + exprValue.getValue());
    }

    /**
     * Sub
     */
    @Override
    public ExpressionValue sub(ExpressionValue exprValue) {
        return exprValue.subInt(this);
    }

    @Override
    public ExpressionValue subInt(IntValue exprValue) {
        return new IntValue(exprValue.getValue() - this.value);
    }

    /**
     * Mul
     */
    @Override
    public ExpressionValue mul(ExpressionValue exprValue) {
        return exprValue.mulInt(this);
    }

    @Override
    public ExpressionValue mulInt(IntValue exprValue) {
        return new IntValue(this.value * exprValue.getValue());
    }

    /**
     * Div
     */
    @Override
    public ExpressionValue div(ExpressionValue exprValue) {
        return exprValue.divInt(this);
    }

    @Override
    public ExpressionValue divInt(IntValue exprValue) {
        return new IntValue(exprValue.getValue() / this.value);
    }

    @Override
    public ExpressionValue negative() {
        return new IntValue( - this.value );
    }

    @Override
    public ExpressionValue positive() {
        return new IntValue(this.value);
    }

    @Override
    public ExpressionValue greater(ExpressionValue exprValue) {
        return exprValue.greaterInt(this);
    }

    @Override
    public ExpressionValue greaterInt(IntValue exprValue) {
        return new BoolValue(exprValue.getValue() > this.value);
    }

    @Override
    public ExpressionValue less(ExpressionValue exprValue) {
        return exprValue.lessInt(this);
    }

    @Override
    public ExpressionValue lessInt(IntValue exprValue) {
        return new BoolValue(exprValue.getValue() < this.value);
    }

    @Override
    public ExpressionValue greaterEqual(ExpressionValue exprValue) {
        return exprValue.greaterEqualInt(this);
    }

    @Override
    public ExpressionValue greaterEqualInt(IntValue exprValue) {
        return new BoolValue(exprValue.getValue() >= this.value);
    }

    @Override
    public ExpressionValue lessEqual(ExpressionValue exprValue) {
        return exprValue.lessEqualInt(this);
    }

    @Override
    public ExpressionValue lessEqualInt(IntValue exprValue) {
        return new BoolValue(exprValue.getValue() <= this.value);
    }
}
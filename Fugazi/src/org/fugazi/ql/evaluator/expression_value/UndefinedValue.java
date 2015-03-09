package org.fugazi.ql.evaluator.expression_value;

public class UndefinedValue extends ExpressionValue {

    public UndefinedValue() {
        super(null);
    }

    @Override
    public boolean isUndefined() {
        return true;
    }
}

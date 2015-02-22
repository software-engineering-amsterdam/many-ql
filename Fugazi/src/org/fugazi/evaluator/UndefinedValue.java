package org.fugazi.evaluator;

public class UndefinedValue extends ExpressionValue {

    public UndefinedValue() {
        super(null);
    }

    @Override
    public boolean isNull() {
        return true;
    }
}

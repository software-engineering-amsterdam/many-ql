package org.fugazi.evaluator;

/**
 * Null Object
 */
public class UndefinedValue extends ExpressionValue {

    public UndefinedValue() {
        super(null);
    }

    @Override
    public boolean isNull() {
        return true;
    }
}

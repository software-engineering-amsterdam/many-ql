package org.fugazi.evaluator;

public class UndefinedValue extends ExpressionValue {

    UndefinedValue() {

    }
    
    @Override
    public ExpressionValue getValue() {
        return null;
    }
    
}

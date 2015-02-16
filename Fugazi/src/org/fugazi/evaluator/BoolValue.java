package org.fugazi.evaluator;

public class BoolValue extends ExpressionValue<Boolean> {
    
    public BoolValue(Boolean _value) {
        super(_value);
    }
    
    public Boolean getValue() {
        return this.value;
    }
}
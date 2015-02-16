package org.fugazi.evaluator;

public class BoolValue extends ExpressionValue {
    
    private final Boolean value;
    
    public BoolValue(Boolean _value) {
        this.value = _value;
    }
    
    public Boolean getValue() {
        return this.value;
    }
}

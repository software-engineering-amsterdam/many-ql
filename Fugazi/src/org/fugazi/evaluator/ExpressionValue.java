package org.fugazi.evaluator;

public abstract class ExpressionValue<T> {

    protected final T value;

    ExpressionValue() {
        this.value = null;
    }
    
    ExpressionValue(T _value) {
        this.value = _value;
    }

    public T getValue() {
        return this.value;
    }
}

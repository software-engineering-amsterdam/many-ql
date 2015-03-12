package com.form.language.ast.values;

import com.form.language.memory.Context;

public class IntValue extends GenericValue {
    private final int value;

    public IntValue(int value) {
	this.value = value;
    }

    public int getValue() {
	return value;
    }

    @Override
    public String toString() {
	return new Integer(value).toString();

    }

    @Override
    public void addToMemory(String key, Context context) {
	context.setValue(key, this);
    }
    
    @Override
    public Boolean equals(GenericValue comparison) {
	return this.value == ((IntValue) comparison).getValue();
    }

}

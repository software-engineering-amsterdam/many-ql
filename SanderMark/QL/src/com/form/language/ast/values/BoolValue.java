package com.form.language.ast.values;

import com.form.language.memory.Context;

public class BoolValue extends GenericValue {
    private final Boolean value;

    public BoolValue(boolean value) {
	this.value = value;
    }

    public Boolean getValue() {
	return value;
    }

    @Override
    public String toString() {
	return new Boolean(value).toString();

    }

    @Override
    public void addToMemory(String key, Context context) {
	context.setValue(key, this);
    }

    @Override
    public boolean equals(Object o) {
	if(o == this){
	    return true;
	}
	if (!(o instanceof BoolValue)){
	    return false;
	}
	BoolValue castO = (BoolValue) o;
	if(value == null){
	    return castO.value == null;
	} else {
	    return this.value.equals(castO.value);
	}
    }

    @Override
    public int hashCode() {
	return (value? 1 : 0);
    }
}

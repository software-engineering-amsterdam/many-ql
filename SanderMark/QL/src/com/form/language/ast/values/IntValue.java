package com.form.language.ast.values;


public class IntValue extends GenericValue {
    private final Integer value;

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
    public boolean equals(Object o) {
	if(o == this){
	    return true;
	}
	if (!(o instanceof IntValue)){
	    return false;
	}
	IntValue castO = (IntValue) o;
	if(value == null){
	    return castO.value == null;
	} else {
	    return value.equals(castO.value);
	}
    }

    @Override
    public int hashCode() {
	return value;
    }
}

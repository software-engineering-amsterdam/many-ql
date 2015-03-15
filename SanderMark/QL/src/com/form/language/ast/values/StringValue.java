package com.form.language.ast.values;

import com.form.language.memory.Context;

public class StringValue extends GenericValue {
    private final String value;

    public StringValue(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }

    @Override
    public void addToMemory(String key, Context context) {
	context.setValue(key, this);
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "\"" + this.value + "\"";
    }
    
    @Override
    public boolean equals(Object o) {
	if(o == this){
	    return true;
	}
	if (!(o instanceof StringValue)){
	    return false;
	}
	StringValue castO = (StringValue) o;
	if(value == null){
	    return castO.value == null;
	} else {
	    return this.value.equals(castO.value);
	}
    }
    
    @Override
    public int hashCode() {
	int result = 17;
	for(int i = 0; i<value.length(); i++){
	    int c = (int)value.charAt(i) ;
	    result = 31 * result + c;
	}
	return result;
    }
}

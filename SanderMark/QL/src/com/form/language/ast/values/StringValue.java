package com.form.language.ast.values;


public class StringValue extends GenericValue {
    private final String value;

    public StringValue(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }

    @Override
    public String toString() {
	return "\"" + value + "\"";
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
	    return value.equals(castO.value);
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

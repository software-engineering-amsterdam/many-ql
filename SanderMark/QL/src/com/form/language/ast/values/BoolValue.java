package com.form.language.ast.values;

public class BoolValue extends GenericValue<Boolean> {
	private final boolean value;
	
	public BoolValue(boolean value) {
		this.value = value;
	}
	public boolean evaluate() {
		return value;
}
	@Override
	public String toString(){
		return new Boolean(value).toString();
		
	}
	
}

package com.form.language.ast.values;

import com.form.language.memory.Context;

public class BoolValue extends GenericValue<Boolean> {
	private final boolean value;
	
	public BoolValue(boolean value) {
		this.value = value;
	}
	public boolean getValue() {
		return value;
}
	@Override
	public String toString(){
		return new Boolean(value).toString();
		
	}
	@Override
	public void addToMemory(String key, Context context) {
		context.setValue(key, this);
	}
	
}

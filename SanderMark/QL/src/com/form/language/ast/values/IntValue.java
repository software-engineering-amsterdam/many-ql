package com.form.language.ast.values;

import com.form.language.memory.RuntimeMemory;

public class IntValue extends GenericValue<Integer>{
	private final int value;
	
	public IntValue(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	} 

	
	@Override
	public String toString(){
		return new Integer(value).toString();
		
	}

	@Override
	public void addToMemory(String key, RuntimeMemory m) {
		m.put(key, value);
	}
}

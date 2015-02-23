package com.form.language.ast.values;

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

}

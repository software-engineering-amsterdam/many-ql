package com.form.language.ast.values;

public class IntValue extends GenericValue<Integer>{
	private final int value;
	
	public IntValue(int value) {
		this.value = value;
	}
	public int evaluate() {
		return value;
	}
	
	public IntValue Add(IntValue addition){
		return new IntValue(value + addition.evaluate());
	}

}

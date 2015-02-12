package com.form.language.ast;

public class IntValue implements AST{
	private final int value;
	
	public IntValue(int value) {
		super();
		this.value = value;
	}
	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return value;
	}

}

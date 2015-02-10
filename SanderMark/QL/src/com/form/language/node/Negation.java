package com.form.language.node;

public class Negation implements AST {
	private final AST op1;
	
	public Negation(AST op1){
		this.op1 = op1;
	}
	
	@Override
	public int evaluate() {
		return -op1.evaluate();
	}
	
}

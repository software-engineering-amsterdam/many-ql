package com.form.language.node;

public class Multiplication implements AST {
	private AST op1;
	private AST op2;
	public Multiplication(AST op1, AST op2) {
		super();
		this.op1 = op1;
		this.op2 = op2;
	}
	@Override
	public int evaluate() {
		return op1.evaluate() * op2.evaluate();
	}
	
	
}

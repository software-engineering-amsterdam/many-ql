package com.form.language.ast.math;

import com.form.language.ast.AST;

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

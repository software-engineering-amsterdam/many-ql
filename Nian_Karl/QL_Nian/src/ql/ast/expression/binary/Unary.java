package ql.ast.expression.binary;

import ql.ast.expression.Expression;

public abstract class Unary extends Expression{
	private final Expression expr;
	
	public Unary(Expression expr){
		this.expr = expr;
	}
}

package org.uva.sea.ql.ast;

public abstract class Unary extends Expr {
	
	protected Expr operand;
	protected String operator;
	
	public Unary(Expr operand, String operator) {
		this.operand = operand;
		this.operator = operator;
	}

	public String show() {
		return this.operator + this.operand.show();
	}
}

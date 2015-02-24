package org.uva.sea.ql.AST.expression;

import org.uva.sea.ql.AST.visitor.Visitor;


public abstract class BinaryExpression extends Expression{
	protected final Expression leftExpression;
	protected final Expression rightExpression;
	
	public BinaryExpression(Expression leftExpression,
			Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	
	public Expression getLeftExpression() {
		return leftExpression;
	}


	public Expression getRightExpression() {
		return rightExpression;
	}
	@Override
	public abstract void accept(Visitor visitor);
	
}

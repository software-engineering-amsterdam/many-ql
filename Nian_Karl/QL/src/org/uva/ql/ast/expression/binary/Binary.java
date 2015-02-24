package org.uva.ql.ast.expression.binary;

import org.uva.ql.ast.expression.Expression;

public abstract class Binary extends Expression {
	
	protected final Expression left;
	protected final Expression right;
	
	public Binary(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	public Expression getLeftExpression() {
		return left;
	}
	
	public Expression getRightExpression() {
		return right;
	}

}

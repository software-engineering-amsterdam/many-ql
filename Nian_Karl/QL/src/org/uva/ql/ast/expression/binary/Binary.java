package org.uva.ql.ast.expression.binary;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.visitor.ExpressionVisitable;

public abstract class Binary extends Expression implements ExpressionVisitable{
	
	protected final Expression left;
	protected final Expression right;
	
	public Binary(Expression left, Expression right,CodePosition pos) {
		super(pos);
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

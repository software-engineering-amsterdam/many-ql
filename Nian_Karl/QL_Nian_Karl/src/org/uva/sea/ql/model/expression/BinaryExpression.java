package org.uva.sea.ql.model.expression;

import org.uva.sea.ql.model.literal.AbstractLiteral;

public abstract class BinaryExpression<T> extends Expression<T>{
	protected AbstractLiteral<T> leftExpression;
	protected AbstractLiteral<T> rightExpression;
	
	public BinaryExpression(AbstractLiteral<T> leftExpression,
			AbstractLiteral<T> rightExpression) {
		super();
		this.setLeftExpression(leftExpression);
		this.setRightExpression(rightExpression);
	}
	
	public AbstractLiteral<T> getLeftExpression() {
		return leftExpression;
	}

	public void setLeftExpression(AbstractLiteral<T> leftExpression) {
		this.leftExpression = leftExpression;
	}

	public AbstractLiteral<T> getRightExpression() {
		return rightExpression;
	}

	public void setRightExpression(AbstractLiteral<T> rightExpression) {
		this.rightExpression = rightExpression;
	}

	public BinaryExpression() {
		
	}

	@Override
	public abstract AbstractLiteral<T> evaluateExpression();
}

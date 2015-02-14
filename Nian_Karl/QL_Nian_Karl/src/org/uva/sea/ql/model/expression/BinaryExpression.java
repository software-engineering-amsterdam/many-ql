package org.uva.sea.ql.model.expression;

public abstract class BinaryExpression<T> extends Expression<T>{
	protected Expression<T> leftExpression;
	protected Expression<T> rightExpression;
	
	public BinaryExpression(Expression<T> leftExpression,
			Expression<T> rightExpression) {
		super();
		this.setLeftExpression(leftExpression);
		this.setRightExpression(rightExpression);
	}
	
	public BinaryExpression() {
		
	}

	public Expression<T> getRightExpression() {
		return rightExpression;
	}

	public void setRightExpression(Expression<T> rightExpression) {
		this.rightExpression = rightExpression;
	}

	public Expression<T> getLeftExpression() {
		return leftExpression;
	}

	public void setLeftExpression(Expression<T> leftExpression) {
		this.leftExpression = leftExpression;
	}

	@Override
	public abstract T evaluateExpression();
}

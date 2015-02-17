package org.uva.sea.ql.model.expression;

import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.value.AbstractValue;

public abstract class BinaryExpression implements Expression{
	protected Expression leftExpression;
	protected Expression rightExpression;
	
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

	public BinaryExpression() {
		
	}

	@Override
	public abstract AbstractValue<?> evaluateExpression();
}

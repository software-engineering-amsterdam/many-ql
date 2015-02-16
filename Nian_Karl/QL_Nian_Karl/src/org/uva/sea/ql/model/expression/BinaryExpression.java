package org.uva.sea.ql.model.expression;

import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.value.AbstractValue;

public abstract class BinaryExpression implements Expression{
	protected AbstractLiteral leftExpression;
	protected AbstractLiteral rightExpression;
	
	public BinaryExpression(AbstractLiteral leftExpression,
			AbstractLiteral rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	
	public AbstractLiteral getLeftExpression() {
		return leftExpression;
	}


	public AbstractLiteral getRightExpression() {
		return rightExpression;
	}

	public BinaryExpression() {
		
	}

	@Override
	public abstract AbstractValue<?> evaluateExpression();
}

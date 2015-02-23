package org.uva.sea.ql.AST.expression.booleanexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.value.AbstractValue;

public class GreaterOrEqualExpression extends BinaryExpression{
	
	
	public GreaterOrEqualExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public AbstractValue<?> interpretExpression() {
		return null;
	}
}

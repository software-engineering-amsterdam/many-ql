package org.uva.sea.ql.AST.expression.booleanexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.value.BooleanValue;

public class GreaterExpression extends BinaryExpression {

	private NumberLiteral leftLiteral = (NumberLiteral) this.leftExpression;
	private NumberLiteral rightLiteral = (NumberLiteral) this.rightExpression;

	public GreaterExpression(Expression leftExpression,
			Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public BooleanValue interpretExpression() {
		int left = leftLiteral.interpretExpression().getValue();
		int right = rightLiteral.interpretExpression().getValue();
		boolean result = left > right;
		return new BooleanValue(result);
	}
}

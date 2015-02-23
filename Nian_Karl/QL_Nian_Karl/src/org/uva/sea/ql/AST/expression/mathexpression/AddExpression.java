package org.uva.sea.ql.AST.expression.mathexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.literal.BooleanLiteral;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.value.IntegerValue;

public class AddExpression extends BinaryExpression {

	public AddExpression(Expression leftExpression,
			Expression rightExpression) {
		super(leftExpression, rightExpression);
	}
	
	@Override
	public IntegerValue interpretExpression() {
		return new IntegerValue(0);
	}	
}
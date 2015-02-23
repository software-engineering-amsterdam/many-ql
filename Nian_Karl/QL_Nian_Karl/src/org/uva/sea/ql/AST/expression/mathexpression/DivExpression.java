package org.uva.sea.ql.AST.expression.mathexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.value.IntegerValue;

public class DivExpression extends BinaryExpression {

	public DivExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public IntegerValue interpretExpression() {
		// int leftInteger = leftLiteral.interpretExpression().getValue();
		// int rightInteger = rightLiteral.interpretExpression().getValue();
		// if (rightInteger > 0) {
		// return new IntegerValue(leftInteger / rightInteger);
		// }else{
		//
		// }
		return new IntegerValue(0);
	}

}
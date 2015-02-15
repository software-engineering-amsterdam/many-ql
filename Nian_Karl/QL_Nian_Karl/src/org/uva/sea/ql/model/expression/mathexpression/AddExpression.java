package org.uva.sea.ql.model.expression.mathexpression;

import org.uva.sea.ql.model.expression.BinaryExpression;
import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.literal.IntegerLiteral;

public class AddExpression extends BinaryExpression<Integer> {
	private IntegerLiteral leftLiteral = (IntegerLiteral) this.leftExpression;
	private IntegerLiteral rightLiteral = (IntegerLiteral) this.rightExpression;
	
	@Override
	public AbstractLiteral<Integer> evaluateExpression() {
		return new IntegerLiteral(leftLiteral.getValue() + rightLiteral.getValue());
	}	
}
package org.uva.sea.ql.model.expression.mathexpression;

import org.uva.sea.ql.model.expression.BinaryExpression;
import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.literal.NumberLiteral;

public class AddExpression extends BinaryExpression<Integer> {
	private NumberLiteral leftLiteral = (NumberLiteral) this.leftExpression;
	private NumberLiteral rightLiteral = (NumberLiteral) this.rightExpression;
	
	@Override
	public AbstractLiteral<Integer> evaluateExpression() {
		return new NumberLiteral(leftLiteral.getValue() + rightLiteral.getValue());
	}	
}
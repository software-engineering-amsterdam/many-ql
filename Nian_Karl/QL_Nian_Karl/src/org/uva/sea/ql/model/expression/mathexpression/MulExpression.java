package org.uva.sea.ql.model.expression.mathexpression;

import org.uva.sea.ql.model.expression.BinaryExpression;
import org.uva.sea.ql.model.literal.NumberLiteral;
import org.uva.sea.ql.model.value.IntegerValue;

public class MulExpression extends BinaryExpression {
	private NumberLiteral leftLiteral = (NumberLiteral) this.leftExpression;
	private NumberLiteral rightLiteral = (NumberLiteral) this.rightExpression;
	
	@Override
	public IntegerValue evaluateExpression() {
		int leftInteger = leftLiteral.evaluateExpression().getValue();
		int rightInteger = rightLiteral.evaluateExpression().getValue();
		return new  IntegerValue(leftInteger * rightInteger);
	}
	
}
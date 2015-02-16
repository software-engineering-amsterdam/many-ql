package org.uva.sea.ql.model.expression.mathexpression;

import org.uva.sea.ql.model.expression.BinaryExpression;
import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.literal.NumberLiteral;
import org.uva.sea.ql.model.value.AbstractValue;
import org.uva.sea.ql.model.value.IntegerValue;

public class DivExpression extends BinaryExpression {
	private NumberLiteral leftLiteral = (NumberLiteral) this.leftExpression;
	private NumberLiteral rightLiteral = (NumberLiteral) this.rightExpression;
	
	@Override
	public IntegerValue evaluateExpression() {
		int leftInteger = leftLiteral.evaluateExpression().getValue();
		int rightInteger = rightLiteral.evaluateExpression().getValue();
		if (rightInteger > 0) {
			return new  IntegerValue(leftInteger / rightInteger);
		}
		// TO-DO cant devive by zero.
		return new  IntegerValue(0);
	}
	
	
}
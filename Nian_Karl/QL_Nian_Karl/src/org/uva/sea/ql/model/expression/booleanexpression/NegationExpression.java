package org.uva.sea.ql.model.expression.booleanexpression;

import org.uva.sea.ql.model.expression.BinaryExpression;
import org.uva.sea.ql.model.literal.AbstractLiteral;

public class NegationExpression extends BinaryExpression<Boolean> {
	
	
	@Override
	public AbstractLiteral<Boolean> evaluateExpression() {
		return null;
	}
}

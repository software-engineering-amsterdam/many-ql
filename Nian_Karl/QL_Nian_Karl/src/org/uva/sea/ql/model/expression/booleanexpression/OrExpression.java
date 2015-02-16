package org.uva.sea.ql.model.expression.booleanexpression;

import org.uva.sea.ql.model.expression.BinaryExpression;
import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.literal.BooleanLiteral;

public class OrExpression extends BinaryExpression<Boolean> {
	private BooleanLiteral leftLiteral = (BooleanLiteral) this.leftExpression;
	private BooleanLiteral rightLiteral = (BooleanLiteral) this.rightExpression;
	
	@Override
	public AbstractLiteral<Boolean> evaluateExpression() {
		return new BooleanLiteral(leftLiteral.getValue() || rightLiteral.getValue());
	}
}

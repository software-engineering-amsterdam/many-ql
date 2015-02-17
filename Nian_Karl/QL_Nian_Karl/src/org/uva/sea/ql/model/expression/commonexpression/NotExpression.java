package org.uva.sea.ql.model.expression.commonexpression;

import org.uva.sea.ql.model.expression.DataTypeExpression;
import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.value.BooleanValue;

public class NotExpression extends DataTypeExpression{
	public NotExpression(AbstractLiteral literal) {
		super(literal);
	}

	@Override
	public BooleanValue evaluateExpression() {
		// TODO Auto-generated method stub
		return null;
	}
}

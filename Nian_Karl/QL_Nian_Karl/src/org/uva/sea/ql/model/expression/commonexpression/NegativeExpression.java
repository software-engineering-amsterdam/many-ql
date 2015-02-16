package org.uva.sea.ql.model.expression.commonexpression;

import org.uva.sea.ql.model.expression.DataTypeExpression;
import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.value.IntegerValue;

public class NegativeExpression extends DataTypeExpression{
	public NegativeExpression(AbstractLiteral literal) {
		super(literal);
	}

	@Override
	public IntegerValue evaluateExpression() {
		// TODO Auto-generated method stub
		return null;
	}
}

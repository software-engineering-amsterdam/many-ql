package org.uva.sea.ql.model.expression.commonexpression;

import org.uva.sea.ql.model.expression.DataTypeExpression;
import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.literal.NumberLiteral;
import org.uva.sea.ql.model.value.IntegerValue;

public class PositiveExpression<T> extends DataTypeExpression{
	
	private NumberLiteral numberLiteral;
	public PositiveExpression(AbstractLiteral literal) {
		super(literal);
		numberLiteral = (NumberLiteral) literal;
	}

	@Override
	public IntegerValue evaluateExpression() {
		IntegerValue intValue = numberLiteral.evaluateExpression();
		return new IntegerValue(Math.abs(intValue.getValue()));
	}
}

package org.uva.sea.ql.AST.expression.commonexpression;

import org.uva.sea.ql.AST.expression.DataTypeExpression;
import org.uva.sea.ql.AST.literal.AbstractLiteral;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.value.IntegerValue;

public class PositiveExpression<T> extends DataTypeExpression{
	
	private NumberLiteral numberLiteral;
	public PositiveExpression(AbstractLiteral literal) {
		super(literal);
		numberLiteral = (NumberLiteral) literal;
	}

	@Override
	public IntegerValue interpretExpression() {
		IntegerValue intValue = numberLiteral.interpretExpression();
		return new IntegerValue(Math.abs(intValue.getValue()));
	}
}

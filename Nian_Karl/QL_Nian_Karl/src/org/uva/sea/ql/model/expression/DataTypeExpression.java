package org.uva.sea.ql.model.expression;

import org.uva.sea.ql.model.literal.AbstractLiteral;
import org.uva.sea.ql.model.value.AbstractValue;

public abstract class DataTypeExpression implements Expression {

	private AbstractLiteral literal;
	
	public DataTypeExpression(AbstractLiteral literal) {
		this.literal = literal;
	}
	
	@Override
	public abstract AbstractValue<?> evaluateExpression();
	
	public AbstractLiteral getLiteral() {
		return literal;
	}

}

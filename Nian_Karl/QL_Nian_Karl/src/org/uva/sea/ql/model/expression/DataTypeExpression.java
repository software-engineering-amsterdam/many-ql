package org.uva.sea.ql.model.expression;

import org.uva.sea.ql.model.literal.AbstractLiteral;

public class DataTypeExpression<T> extends Expression<T> {

	private AbstractLiteral<T> literal;
	
	public DataTypeExpression(AbstractLiteral<T> literal) {
		this.literal = literal;
	}
	
	@Override
	public AbstractLiteral<T> evaluateExpression() {
		return literal;
	}
	
	public AbstractLiteral<T> getLiteral() {
		return literal;
	}
}

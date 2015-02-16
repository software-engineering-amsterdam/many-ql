package org.uva.sea.ql.model.expression;

import org.uva.sea.ql.model.literal.AbstractLiteral;


public abstract class Expression<T> {
	
	public abstract AbstractLiteral<T> evaluateExpression();
}

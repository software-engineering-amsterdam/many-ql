package org.uva.sea.ql.model.expression;

import org.uva.sea.ql.model.value.AbstractValue;


public interface Expression {	
	public abstract AbstractValue<?> evaluateExpression();
}
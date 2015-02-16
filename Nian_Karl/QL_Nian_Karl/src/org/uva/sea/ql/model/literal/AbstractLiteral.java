package org.uva.sea.ql.model.literal;

import org.uva.sea.ql.model.expression.Expression;
import org.uva.sea.ql.model.value.AbstractValue;

public abstract class AbstractLiteral implements Expression{ 
	@Override
	public abstract AbstractValue<?> evaluateExpression();
}

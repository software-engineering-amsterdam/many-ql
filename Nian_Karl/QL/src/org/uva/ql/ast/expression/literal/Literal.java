package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.expression.Expression;

public abstract class Literal extends Expression{
	
	public abstract Object getValue();
	
}

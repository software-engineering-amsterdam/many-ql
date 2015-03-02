package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.expression.Expression;

public abstract class Literal extends Expression{
	
	public Literal(CodePosition pos) {
		super(pos);
	}

	public abstract Object getValue();
	
}

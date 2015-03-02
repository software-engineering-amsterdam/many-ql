package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.visitor.ExpressionVisitable;

public abstract class Literal extends Expression implements ExpressionVisitable{
	
	public Literal(CodePosition pos) {
		super(pos);
	}

	public abstract Object getValue();


}

package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.value.Value;

public abstract class Literal extends Expression{
	
	public Literal(CodePosition pos) {
		super(pos);
	}
	
	public abstract <T extends Value> T getValue();

}

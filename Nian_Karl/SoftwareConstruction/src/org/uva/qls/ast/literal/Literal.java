package org.uva.qls.ast.literal;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.type.Type;
import org.uva.qls.ast.value.Value;
import org.uva.qls.visitor.LiteralVisitable;

public abstract class Literal extends BaseNode implements LiteralVisitable{
	
	public Literal(CodePosition pos) {
		super(pos);
	}
	
	public abstract Value getValue();
	public abstract Type getType();
	public String toString() {
		return "Literal";
	}
}

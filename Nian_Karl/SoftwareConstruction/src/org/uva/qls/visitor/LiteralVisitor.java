package org.uva.qls.visitor;

import org.uva.qls.ast.literal.StrLiteral;

public interface LiteralVisitor<T> {

	public T visit(StrLiteral node);
	
}

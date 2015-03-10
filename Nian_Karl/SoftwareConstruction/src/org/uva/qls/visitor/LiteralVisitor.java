package org.uva.qls.visitor;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.StrLiteral;

public interface LiteralVisitor<T> {

	public T visit(StrLiteral node);
	public T visit(Identifier identifier);
	
}

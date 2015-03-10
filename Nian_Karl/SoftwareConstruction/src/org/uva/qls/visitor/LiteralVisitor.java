package org.uva.qls.visitor;

import org.uva.ql.ast.expression.literal.BoolLiteral;
import org.uva.qls.ast.literal.Identifier;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.StrLiteral;

public interface LiteralVisitor<T> {

	public T visit(StrLiteral node);
	public T visit(Identifier identifier);
	
}

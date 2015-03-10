package org.uva.qls.visitor;

import org.uva.qls.ast.literal.StrLiteral;

public interface LiteralVisitor<T> {

	public T visit(IntLiteral node);
	public T visit(BoolLiteral node); 
	public T visit(StrLiteral node);
	
}

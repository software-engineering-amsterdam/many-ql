package org.uva.qls.visitor;

import org.uva.qls.ast.type.BoolType;
import org.uva.qls.ast.type.ColorType;
import org.uva.qls.ast.type.IntType;
import org.uva.qls.ast.type.IdentifierType;
import org.uva.qls.ast.type.StrType;

public interface TypeVisitor<T> {

	public T visit(IntType node);
	public T visit(BoolType node);
	public T visit(StrType node);
	public T visit(ColorType node);
	public T visit(IdentifierType identifier);
	
}

package org.uva.qls.visitor;

import org.uva.qls.ast.type.BoolType;
import org.uva.qls.ast.type.IntType;
import org.uva.qls.ast.type.RgbType;
import org.uva.qls.ast.type.StrType;
import org.uva.qls.ast.type.UndefinedType;

public interface TypeVisitor<T> {

	public T visit(IntType node);
	public T visit(BoolType node);
	public T visit(StrType node);
	public T visit(RgbType node);
	
}

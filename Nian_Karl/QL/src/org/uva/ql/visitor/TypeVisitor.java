package org.uva.ql.visitor;

import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.type.UndefinedType;

public interface TypeVisitor<T> {

	public T visit(IntType node);

	public T visit(BoolType node);

	public T visit(StrType node);

	public T  visit(UndefinedType undefiendType);

}

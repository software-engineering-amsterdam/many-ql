package org.uva.ql.ast.type;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.visitor.TypeVisitor;

public class IntType extends Type {

	public IntType() {
		super();
	}

	public IntType(CodePosition pos) {
		super(pos);
	}

	@Override
	public boolean isInt() {
		return true;
	}

	@Override
	public boolean isEqual(Type type) {
		return type.isInt();
	}

	@Override
	public String toString() {
		return "Int";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

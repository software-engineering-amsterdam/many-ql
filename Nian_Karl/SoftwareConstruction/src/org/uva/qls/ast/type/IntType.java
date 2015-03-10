package org.uva.qls.ast.type;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.visitor.TypeVisitor;

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

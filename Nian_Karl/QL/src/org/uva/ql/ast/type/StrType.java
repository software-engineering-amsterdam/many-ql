package org.uva.ql.ast.type;

import org.uva.ql.visitor.TypeVisitor;

public class StrType extends Type {

	@Override
	public boolean isStr() {
		return true;
	}

	@Override
	public boolean isEqual(Type type) {
		return type.isStr();
	}

	@Override
	public String toString() {
		return "Str";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}

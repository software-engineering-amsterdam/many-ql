package org.uva.ql.ast.type;

import org.uva.ql.visitor.TypeVisitor;

public class UndefinedType extends Type {

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isEqual(Type type) {
		return type.isUndefined();
	}

	@Override
	public boolean isUndefined() {
		return true;
	}

}

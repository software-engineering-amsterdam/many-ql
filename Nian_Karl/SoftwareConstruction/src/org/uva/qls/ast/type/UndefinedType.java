package org.uva.qls.ast.type;

import org.uva.qls.visitor.TypeVisitor;

public class UndefinedType extends Type {

	@Override
	public boolean isUndefined() {
		return true;
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isEqual(Type type) {
		return type.isUndefined();
	}
	
	@Override
	public String toString() {
		return "Undefined";
	}
	
}

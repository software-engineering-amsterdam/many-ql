package org.uva.qls.ast.type;

import org.uva.qls.visitor.TypeVisitor;

public class IntType extends Type {

	@Override
	public boolean isInt() {
		return true;
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isEqual(Type type) {
		return type.isInt();
	}

	@Override
	public String toString() {
		return "Int";
	}
	
	
}

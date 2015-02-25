package org.uva.ql.ast.type;

import org.uva.ql.ast.visitor.Visitor;

public class BoolType extends Type {

	@Override
	public boolean isBool() {
		return true;
	}
	
	@Override
	public boolean isEqual(Type type) {
		return type.isBool();
	}
	
	@Override
	public String toString() {
		return "Bool";
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
}

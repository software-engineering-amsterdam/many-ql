package org.uva.qls.ast.type;

import org.uva.qls.visitor.TypeVisitor;
import org.uva.utility.CodePosition;

public class BoolType extends Type {

	public BoolType() {
		super();
	}
	public BoolType(CodePosition pos) {
		super(pos);
	}

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
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}

package ql.ast.type;

import ql.ast.QLType;
import ql.ast.visitor.TypeVisitor;

public class QLBoolean extends QLType {
	public QLBoolean() {
		compatibleTypes.add(this);
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {	
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "boolean";
	}
}

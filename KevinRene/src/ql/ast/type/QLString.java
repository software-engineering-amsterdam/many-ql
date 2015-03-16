package ql.ast.type;

import ql.ast.QLType;
import ql.ast.visitor.TypeVisitor;

public class QLString extends QLType {		
	public QLString() {
		compatibleTypes.add(this);
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "string";
	}
}

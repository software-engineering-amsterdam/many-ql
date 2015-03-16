package ql.ast.type;

import ql.ast.visitor.TypeVisitor;

public class QLInteger extends QLNumeric {	
	public QLInteger() {
		compatibleTypes.add(this);
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "integer";
	}
}

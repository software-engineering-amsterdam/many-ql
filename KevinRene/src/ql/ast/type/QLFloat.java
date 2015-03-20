package ql.ast.type;

import ql.ast.visitor.TypeVisitor;

public class QLFloat extends QLNumeric {
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "float";
	}
}

package ql.ast.type;

import ql.ast.QLType;
import ql.ast.visitor.TypeVisitor;

public class QLNumeric extends QLType {
	public QLNumeric() {
		compatibleTypes.add(this);
	}
	
	@Override
	public boolean compatibleWith(QLType type) {
		return compatibleTypes.contains(type) 
				|| type instanceof QLNumeric;
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}

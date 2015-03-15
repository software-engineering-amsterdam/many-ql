package ql.ast.type;

import ql.ast.visitor.ExpressionVisitor;

public class QLInteger extends QLNumeric {	
	public QLInteger() {
		compatibleTypes.add(this);
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}	
}

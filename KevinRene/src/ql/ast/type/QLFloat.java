package ql.ast.type;

import ql.ast.visitor.ExpressionVisitor;

public class QLFloat extends QLNumeric {
	public QLFloat() {
		compatibleTypes.add(this);
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}

package ql.ast.expression.type;

import ql.ast.expression.QLType;
import ql.ast.visitor.ExpressionVisitor;

public class QLInteger extends QLNumeric {	
	public QLInteger() {}
	
	@Override
	public QLType getType() {
		return new QLInteger();
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}

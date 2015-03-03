package ql.ast.expression.type;

import ql.ast.expression.QLType;
import ql.ast.visitor.Visitor;

public class QLInteger extends QLNumeric {	
	public QLInteger() {}
	
	@Override
	public QLType getType() {
		return new QLInteger();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}

package ql.ast.expression.type;

import ql.ast.expression.QLType;
import ql.ast.visitor.Visitor;

public class QLFloat extends QLNumeric {
	public QLFloat() {}
	
	@Override
	public QLType getType() {
		return new QLFloat();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}

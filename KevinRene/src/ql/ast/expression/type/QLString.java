package ql.ast.expression.type;

import java.util.Arrays;

import ql.ast.expression.QLType;
import ql.ast.visitor.Visitor;

public class QLString extends QLType {		
	public QLString() {
		super(Arrays.asList(QLString.class));
	}
	
	@Override
	public QLType getType() {
		return new QLString();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}

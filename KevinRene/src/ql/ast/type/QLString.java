package ql.ast.type;

import java.util.Arrays;

import ql.ast.QLType;
import ql.ast.visitor.ExpressionVisitor;

public class QLString extends QLType {		
	public QLString() {
		super(Arrays.asList(QLString.class));
	}
	
	@Override
	public QLType getType() {
		return new QLString();
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}

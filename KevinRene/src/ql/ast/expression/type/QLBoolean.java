package ql.ast.expression.type;

import java.util.Arrays;

import ql.ast.expression.QLType;
import ql.ast.visitor.ExpressionVisitor;

public class QLBoolean extends QLType {
	public QLBoolean() {
		super(Arrays.asList(QLBoolean.class));
	}

	@Override
	public QLType getType() {
		return new QLBoolean();
	}
		
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {	
		System.out.println("TRWRWR");
		return visitor.visit(this);
	}
}

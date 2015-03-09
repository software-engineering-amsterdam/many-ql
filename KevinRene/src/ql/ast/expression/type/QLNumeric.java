package ql.ast.expression.type;

import java.util.Arrays;

import ql.ast.expression.QLType;
import ql.ast.visitor.ExpressionVisitor;

public class QLNumeric extends QLType {
	public QLNumeric() {
		super(Arrays.asList(QLFloat.class, QLInteger.class, QLNumeric.class));
	}

	@Override
	public QLType getType() {
		return new QLNumeric();
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}

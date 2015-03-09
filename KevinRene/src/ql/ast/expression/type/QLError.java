package ql.ast.expression.type;

import java.util.Arrays;

import ql.ast.expression.QLType;
import ql.ast.visitor.ExpressionVisitor;

public class QLError extends QLType {

	public QLError() {
		super(Arrays.asList());
	}

	@Override
	public QLType getType() {
		return new QLError();
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}

package ql.ast.expression.literal;

import ql.ast.QLType;
import ql.ast.expression.Literal;
import ql.ast.visitor.ExpressionVisitor;
import ql.value.BooleanValue;

public class BooleanLiteral extends Literal<BooleanValue> {

	public BooleanLiteral(boolean value) {
		super(new BooleanValue(value));
	}

	@Override
	public QLType getType() {
		return getValue().getType();
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

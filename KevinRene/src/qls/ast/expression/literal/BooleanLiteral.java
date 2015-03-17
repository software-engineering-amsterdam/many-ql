package qls.ast.expression.literal;

import qls.value.BooleanValue;
import qls.ast.expression.Literal;
import qls.ast.visitor.ExpressionVisitor;

public class BooleanLiteral extends Literal<BooleanValue> {
	public BooleanLiteral(BooleanValue value) {
		super(value);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

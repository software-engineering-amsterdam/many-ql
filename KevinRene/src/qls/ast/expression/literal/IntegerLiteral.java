package qls.ast.expression.literal;

import qls.value.IntegerValue;
import qls.ast.expression.Literal;
import qls.ast.visitor.ExpressionVisitor;

public class IntegerLiteral extends Literal<IntegerValue> {
	public IntegerLiteral(IntegerValue value) {
		super(value);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

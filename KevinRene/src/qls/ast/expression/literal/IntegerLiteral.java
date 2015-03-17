package qls.ast.expression.literal;

import qls.value.IntegerValue;
import qls.ast.expression.Literal;
import qls.ast.visitor.ExpressionVisitor;

public class IntegerLiteral extends Literal<IntegerValue> {
	public IntegerLiteral(int value) {
		super(new IntegerValue(value));
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

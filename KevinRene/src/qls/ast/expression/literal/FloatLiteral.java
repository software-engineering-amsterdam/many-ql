package qls.ast.expression.literal;

import ql.ast.QLType;
import ql.value.FloatValue;
import qls.ast.expression.Literal;
import qls.ast.visitor.ExpressionVisitor;

public class FloatLiteral extends Literal<FloatValue> {
	public FloatLiteral(float value) {
		super(new FloatValue(value));
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

package qls.ast.expression.literal;

import ql.ast.QLType;
import ql.ast.type.QLFloat;
import qls.ast.expression.Literal;
import qls.ast.visitor.ExpressionVisitor;
import qls.value.FloatValue;

public class FloatLiteral extends Literal<FloatValue> {
	public FloatLiteral(float value) {
		super(new FloatValue(value));
	}

	@Override
	public QLType getType() {
		return new QLFloat();
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

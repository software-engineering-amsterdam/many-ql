package qls.ast.expression.literal;

import ql.ast.QLType;
import ql.ast.type.QLBoolean;
import qls.ast.expression.Literal;
import qls.ast.visitor.ExpressionVisitor;
import qls.value.BooleanValue;

public class BooleanLiteral extends Literal<BooleanValue> {
	public BooleanLiteral(boolean value) {
		super(new BooleanValue(value));
	}
	
	@Override
	public QLType getType() {
		return new QLBoolean();
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

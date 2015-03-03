package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.expression.QLType;
import ql.ast.expression.type.QLBoolean;
import ql.ast.visitor.Visitor;
import ql.value.BooleanValue;

public class BooleanLiteral extends Literal<BooleanValue> {

	public BooleanLiteral(boolean value) {
		super(new BooleanValue(value));
	}

	@Override
	public QLType getType() {
		return new QLBoolean();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}

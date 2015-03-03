package qls.ast.literal;

import ql.ast.expression.QLType;
import ql.ast.expression.type.QLBoolean;
import ql.value.BooleanValue;
import qls.ast.Literal;
import qls.ast.visitor.Visitor;

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

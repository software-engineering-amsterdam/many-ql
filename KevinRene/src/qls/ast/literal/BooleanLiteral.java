package qls.ast.literal;

import qls.ast.Literal;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLBoolean;
import qls.ast.visitor.Visitor;
import cons.value.BooleanValue;

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

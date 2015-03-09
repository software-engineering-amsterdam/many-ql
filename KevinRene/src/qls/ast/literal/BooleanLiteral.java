package qls.ast.literal;

import qls.ast.Literal;
import qls.ast.QLSType;
import qls.ast.type.QLSBoolean;
import qls.ast.visitor.Visitor;

public class BooleanLiteral extends Literal<Boolean> {
	public BooleanLiteral(boolean value) {
		super(value);
	}

	@Override
	public QLSType getType() {
		return new QLSBoolean();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}

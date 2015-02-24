package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.Literal;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.visitor.Visitor;

public class BooleanLiteral extends Literal<Boolean> {

	public BooleanLiteral(boolean value) {
		super(value);
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

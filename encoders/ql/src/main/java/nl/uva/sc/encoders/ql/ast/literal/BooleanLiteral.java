package nl.uva.sc.encoders.ql.ast.literal;

import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.visitor.LiteralVisitor;

public class BooleanLiteral implements Literal {

	private final Boolean value;

	public BooleanLiteral(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	@Override
	public DataType getType() {
		return new BooleanType();
	}

	@Override
	public <T> T accept(LiteralVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

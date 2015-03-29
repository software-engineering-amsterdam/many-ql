package nl.uva.sc.encoders.ql.ast.literal;

import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.visitor.LiteralVisitor;

public class IntegerLiteral implements Literal {

	private final int value;

	public IntegerLiteral(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public DataType getType() {
		return new IntegerType();
	}

	@Override
	public <T> T accept(LiteralVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "" + value;
	}
}

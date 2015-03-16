package nl.uva.sc.encoders.ql.ast.expression.literal;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

public class IntegerLiteral extends Expression {

	private final int value;

	public IntegerLiteral(TextLocation textLocation, int value) {
		super(textLocation);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

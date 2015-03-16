package nl.uva.sc.encoders.ql.ast.expression.literal;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

public class BooleanLiteral extends Expression {

	private final Boolean value;

	public BooleanLiteral(TextLocation textLocation, Boolean value) {
		super(textLocation);
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

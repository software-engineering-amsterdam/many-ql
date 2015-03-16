package org.uva.sea.ql.encoders.ast.expression.literal;

import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.visitor.ExpressionVisitor;

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

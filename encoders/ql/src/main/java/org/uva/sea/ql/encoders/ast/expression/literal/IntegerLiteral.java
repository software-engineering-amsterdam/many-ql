package org.uva.sea.ql.encoders.ast.expression.literal;

import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.visitor.AstVisitor;

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
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}

}

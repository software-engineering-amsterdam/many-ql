package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.AstVisitor;
import org.uva.sea.ql.encoders.ast.TextLocation;

public class IntegerExpression extends Expression {

	private final int integerLiteral;

	public IntegerExpression(TextLocation textLocation, int integerLiteral) {
		super(textLocation);
		this.integerLiteral = integerLiteral;
	}

	public int getIntegerLiteral() {
		return integerLiteral;
	}

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}

}

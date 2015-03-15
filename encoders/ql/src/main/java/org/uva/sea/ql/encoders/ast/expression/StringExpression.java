package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.visitor.AstVisitor;

public class StringExpression extends Expression {

	private final String stringLiteral;

	public StringExpression(TextLocation textLocation, String stringLiteral) {
		super(textLocation);
		this.stringLiteral = stringLiteral;
	}

	public String getStringLiteral() {
		return stringLiteral;
	}

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

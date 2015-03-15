package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.visitor.AstVisitor;

public class StringLiteral extends Expression {

	private final String value;

	public StringLiteral(TextLocation textLocation, String value) {
		super(textLocation);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

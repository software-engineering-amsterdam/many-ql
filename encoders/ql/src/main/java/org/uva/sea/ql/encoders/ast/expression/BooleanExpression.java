package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.AstVisitor;
import org.uva.sea.ql.encoders.ast.TextLocation;

public class BooleanExpression extends Expression {

	private final Boolean booleanLiteral;

	public BooleanExpression(TextLocation textLocation, Boolean booleanLiteral) {
		super(textLocation);
		this.booleanLiteral = booleanLiteral;
	}

	public Boolean getBooleanLiteral() {
		return booleanLiteral;
	}

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}

}

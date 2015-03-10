package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.AstVisitor;
import org.uva.sea.ql.encoders.ast.TextLocation;

public class NameExpression extends Expression {

	private String name;

	public NameExpression(TextLocation textLocation, String name) {
		super(textLocation);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

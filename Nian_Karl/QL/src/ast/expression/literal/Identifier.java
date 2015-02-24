package ast.expression.literal;

import ast.visitor.Visitor;

public class Identifier extends Literal {

	private final String value;

	public Identifier(String value) {
		this.value = value;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}

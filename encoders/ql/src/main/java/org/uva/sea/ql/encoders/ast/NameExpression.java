package org.uva.sea.ql.encoders.ast;


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

}

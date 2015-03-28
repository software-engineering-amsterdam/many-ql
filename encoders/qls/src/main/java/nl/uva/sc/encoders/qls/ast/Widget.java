package nl.uva.sc.encoders.qls.ast;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Widget extends AstNode {

	private final String name;

	public Widget(TextLocation textLocation, String name) {
		super(textLocation);
		this.name = name;
	}

	public String getWidgetName() {
		return name;
	}
}

package nl.uva.sc.encoders.qls.ast;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Widget extends AstNode {

	private String type;

	public Widget(TextLocation textLocation) {
		super(textLocation);
	}

	public void setWidgetType(String type) {
		this.type = type;
	}

	public String getWidgetType() {
		return type;
	}

}

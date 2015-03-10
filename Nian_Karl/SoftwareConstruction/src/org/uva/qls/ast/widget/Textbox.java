package org.uva.qls.ast.widget;

import org.uva.utility.CodePosition;

public class Textbox extends WidgetType {

	public Textbox(CodePosition position) {
		super(position);
	}
	
	@Override
	public String toString() {
		return "textbox";
	}
	
}

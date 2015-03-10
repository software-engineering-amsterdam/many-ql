package org.uva.qls.ast.widget;

import org.uva.qls.ast.CodePosition;

public class TextboxModel extends WidgetType {

	public TextboxModel(CodePosition position) {
		super(position);
	}
	
	@Override
	public String toString() {
		return "textbox";
	}
	
}

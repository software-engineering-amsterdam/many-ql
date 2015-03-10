package org.uva.qls.ast.widget;

import org.uva.utility.CodePosition;

public class Checkbox extends WidgetType {

	public Checkbox(CodePosition position) {
		super(position);
	}
	
	@Override
	public String toString() {
		return "checkbox";
	}
}

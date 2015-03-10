package org.uva.qls.ast.widget;

import org.uva.qls.ast.CodePosition;

public class CheckboxModel extends WidgetType {

	public CheckboxModel(CodePosition position) {
		super(position);
	}
	
	@Override
	public String toString() {
		return "checkbox";
	}
}

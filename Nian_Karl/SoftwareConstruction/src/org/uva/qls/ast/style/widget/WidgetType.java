package org.uva.qls.ast.style.widget;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.ast.style.StyleProperty;

public abstract class WidgetType extends StyleProperty {

	public WidgetType(CodePosition pos) {
		super(pos);
	}
}

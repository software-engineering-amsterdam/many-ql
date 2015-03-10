package org.uva.qls.ast;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.qls.view.widget.Widget;
import org.uva.utility.CodePosition;

public class QuestionWidget extends Question {

	private final Widget<?> widget;

	public QuestionWidget(Identifier identifier, Widget<?> widget, CodePosition pos) {
		super(identifier, pos);
		this.widget = widget;
	}

	public Widget<?> getWidget() {
		return widget;

	}

}

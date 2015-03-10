package org.uva.qls.ast;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.qls.view.widget.Widget;

public class QuestionWidget extends Question {

	private final Widget<?> widget;

	public QuestionWidget(Identifier identifier, Widget<?> widget) {
		super(identifier);
		this.widget = widget;
	}

	public Widget<?> getWidget() {
		return widget;
	}

}

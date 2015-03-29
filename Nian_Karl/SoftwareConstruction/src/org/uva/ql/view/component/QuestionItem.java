package org.uva.ql.view.component;

import java.awt.Component;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.view.panel.Panel;
import org.uva.ql.view.widget.Label;
import org.uva.ql.view.widget.Widget;

public class QuestionItem extends Panel {

	private QuestionNormal question;
	private Label label;
	protected final Widget widget;

	public QuestionItem(QuestionNormal question, Widget widget) {
		super();
		this.question = question;
		this.label = new Label(question.getText());
		this.widget = widget;
		addComponent(label, "span");
		addComponent((Component) this.widget.getWidget(), "span,growx");
	}

	public Widget getWidget() {
		return widget;
	}

	public Identifier getIdentifier() {
		return question.getIdentifier();

	}

}

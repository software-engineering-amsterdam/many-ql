package org.uva.ql.view.component;

import java.awt.Component;

import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.view.panel.Panel;
import org.uva.ql.view.widgit.Label;
import org.uva.ql.view.widgit.Widget;

public class QuestionComponent extends Panel {

	private QuestionNormal question;
	private Label label;
	protected final Widget widget;

	public QuestionComponent(QuestionNormal question, Widget widget) {
		super();
		this.question = question;
		this.label = new Label(question.getText());
		this.widget = widget;
		widget.setIdentifier(question.getIdentifier());
		addComponent(label);
		addComponent((Component) this.widget.getWidget());
	}

	public Widget getWidget() {
		return widget;
	}

	public QuestionNormal getQuestion() {
		return question;
	}

}

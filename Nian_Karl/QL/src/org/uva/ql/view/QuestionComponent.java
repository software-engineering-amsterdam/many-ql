package org.uva.ql.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.view.widgit.Label;
import org.uva.ql.view.widgit.Widget;

public class QuestionComponent extends Panel {

	private static final long serialVersionUID = 134684077598012568L;

	private QuestionNormal question;
	private Label label;
	protected final Widget widget;

	public QuestionComponent(QuestionNormal question, Widget widget) {
		setLayout(new GridLayout());
		this.question = question;
		this.label = new Label(question.getText());
		this.widget = widget;


		widget.setIdentifier(question.getIdentifier().toString());
		setPreferredSize(new Dimension(350, 50));
		setBackground(Color.lightGray);
		add(label);
		add((Component) this.widget.getWidget());
	}

	public Widget getWidget() {
		return widget;
	}

	public QuestionNormal getQuestion() {
		return question;
	}

}

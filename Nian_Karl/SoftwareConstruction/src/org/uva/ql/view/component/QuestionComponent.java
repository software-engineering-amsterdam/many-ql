package org.uva.ql.view.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.view.panel.Panel;
import org.uva.ql.view.widgit.Label;
import org.uva.ql.view.widgit.Widget;

public class QuestionComponent extends Panel{

	private static final long serialVersionUID = 134684077598012568L;

	private QuestionNormal question;
	private Label label;
	protected final Widget widget;

	public QuestionComponent(QuestionNormal question, Widget widget) {
		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);
		this.question = question;
		this.label = new Label(question.getText());
		this.widget = widget;
		widget.setIdentifier(question.getIdentifier());
		setBackground(Color.red);

		// Making GridBagConstraints for label
		Insets inset = new Insets(5, 5, 5, 5);
		GridBagConstraints labelConstraints = new GridBagConstraints();
		labelConstraints.gridx = 0;
		labelConstraints.gridy = 0;
		labelConstraints.insets = inset;
		add(label, labelConstraints);

		// Making GridBagConstraints for widget
		GridBagConstraints widgetConstraints = new GridBagConstraints();
		widgetConstraints.gridx = 1;
		widgetConstraints.gridy = 0;
		widgetConstraints.fill = GridBagConstraints.HORIZONTAL;
		widgetConstraints.insets = inset;
		add((Component) this.widget.getWidget(), widgetConstraints);
	}

	public Widget getWidget() {
		return widget;
	}

	public QuestionNormal getQuestion() {
		return question;
	}

}

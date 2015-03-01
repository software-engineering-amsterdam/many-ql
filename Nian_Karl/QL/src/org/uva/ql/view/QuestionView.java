package org.uva.ql.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.view.widgit.QLCheckBox;
import org.uva.ql.view.widgit.QLLabel;
import org.uva.ql.view.widgit.QLWidget;

public class QuestionView extends ComponentView {

	private static final long serialVersionUID = 1L;

	private QuestionNormal question;
	private QLLabel label;
	private QLWidget widget;

	public QuestionView(QuestionNormal question) {
		super();
		this.question = question;
		this.label = new QLLabel("hoi");
		this.widget = new QLCheckBox("myIdentifier");
		setSize(200, 50);
		setBackground(new Color(255, 255, 0, 1));
		add(label);
		add((JComponent) widget);
	}

	public QuestionNormal getQuestion() {
		return question;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
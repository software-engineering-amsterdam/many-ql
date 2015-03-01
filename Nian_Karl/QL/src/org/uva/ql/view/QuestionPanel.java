package org.uva.ql.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.view.widgit.QLCheckBox;
import org.uva.ql.view.widgit.QLLabel;
import org.uva.ql.view.widgit.QLTextField;
import org.uva.ql.view.widgit.QLWidget;

public class QuestionPanel extends Panel {

	private static final long serialVersionUID = 1L;

	private QuestionNormal question;
	private QLLabel label;
	private QLWidget widget;

	public QuestionPanel(QuestionNormal question) {
		super();
		this.question = question;
		this.label = new QLLabel(question.getText());
		Random r = new Random();
		System.out.println(r.nextInt(2));
		if (r.nextInt(2) == 1) {
			this.widget = new QLCheckBox("myIdentifier");
		}else{
			this.widget = new QLTextField("myIdentifier");
		}
		
		setPreferredSize(new Dimension(350, 50));
		
		setBackground(Color.lightGray);
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
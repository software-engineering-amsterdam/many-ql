package org.uva.ql.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;

import org.uva.ql.ast.statement.QuestionNormal;

public class QuestionView extends JComponent{

	private JLabel questionLabel;

	public QuestionView(QuestionNormal statement){
		super();
		this.setSize(200, 200);
		questionLabel = new JLabel(statement.getQuestionLabel());
		questionLabel.setSize(50,50);
		questionLabel.setLocation(100,100);
		questionLabel.setVisible(true);
		setBackground(new Color(255, 0, 0, 1));
		setLocation(50, 50);
		setVisible(true);
//		setLayout(new BorderLayout());
	}
}

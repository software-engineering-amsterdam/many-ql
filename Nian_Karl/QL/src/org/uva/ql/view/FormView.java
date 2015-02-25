package org.uva.ql.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.type.QuestionType;

public class FormView extends JFrame{

	public FormView() {
		QuestionNormal normalQuestion = new QuestionNormal(QuestionType.BOOL, "MyIdentifier", "How are you");
		QuestionView questionView = new QuestionView(normalQuestion);
		JLabel jlbHelloWorld = new JLabel("Hello World");
		getContentPane().add(questionView);
		getContentPane().add(jlbHelloWorld);
		this.setSize(600, 400);
//		 pack();
		setVisible(true);
	}
	
}

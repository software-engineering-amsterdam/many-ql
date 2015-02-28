package org.uva.ql.view;

import java.awt.Color;

import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.view.widgit.QLCheckBox;
import org.uva.ql.view.widgit.QLLabel;
import org.uva.ql.view.widgit.QLWidget;

public class QuestionView extends ComponentView {

	private static final long serialVersionUID = 1L;

	private QuestionNormal question;
	private QLLabel label;
	private QLWidget widget;

	public QuestionView(QuestionNormal question){
		this.question = question;
		System.out.println(this.question.getLabel());
		this.label = new QLLabel("hoi"); 
		// how to distinguish which type of widget on question?
		this.widget = new QLCheckBox("myIdentifier");
		this.setBounds(10, 10, 200, 50);
		this.setBackground(new Color(255, 0, 0, 1));
		this.setVisible(true);
	}
}
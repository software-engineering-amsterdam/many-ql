package com.form.language.gui.components;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.gui.widget.CheckBox;
import com.form.language.gui.widget.Label;
import com.form.language.gui.widget.TextField;

public class QuestionComponent extends JPanel {

	private static final long serialVersionUID = 134684077598012568L;

	private Question question;
	private JLabel label;
	private Expression showCondition;

	public QuestionComponent(Question question, Expression showCondition) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); 
		this.question = question;
		this.label = new Label(question.getText());
		this.showCondition = showCondition;
		add(label);
		createQuestionType();
	}
	
	//Type checker implementation to be added
	private void createQuestionType()
	{
		if(question.getType().isBoolType())
		{
			CheckBox checkbox = new CheckBox(showCondition);
			checkbox.setName(question.getId());
			add(checkbox);			
		}
		else if(question.getType().isStringType())
		{
			TextField textfield = new TextField(showCondition);
			textfield.setName(question.getId());
			add(textfield);			
		}
		else
		{
			TextField textfield = new TextField(showCondition);
			textfield.setName(question.getId());
			add(textfield);				
		}
	}
	
	public Question getQuestion() {
		return question;
	}
}

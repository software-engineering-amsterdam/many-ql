package com.form.language.gui.components;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.gui.widget.CheckBox;
import com.form.language.gui.widget.Label;
import com.form.language.gui.widget.TextField;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollector;

public class QuestionComponent extends JPanel {

	private static final long serialVersionUID = 134684077598012568L;

	private Question question;
	private JLabel label;
	private Expression showCondition;
	private Context rm;
	
	public QuestionComponent(Question question, Context rm, Expression showCondition) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); 
		this.question = question;
		this.label = new Label(question.getText());
		this.showCondition = showCondition;
		this.rm = rm;
		add(label);
		
		//Belongs to if statement
		if(showCondition != null)
		{
			this.setVisible(false);
			rm.putExp(showCondition, this);
			
			IdCollector idCollector = new IdCollector();
			showCondition.collectIds(idCollector);
			rm.putDependencie(idCollector, showCondition);
		}
		createQuestionType();
	}
	
	//Type checker implementation to be added
	private void createQuestionType()
	{
		if(question.getType(rm).isBoolType())
		{
			//CheckBox checkbox = new CheckBox(question,this,showCondition,rm);
			CheckBox checkbox = new CheckBox(question,this,rm);
			checkbox.setName(question.getId());
			add(checkbox);			
		}
		else if(question.getType(rm).isStringType())
		{
			//TextField textfield = new TextField(question,this,showCondition,rm);
			TextField textfield = new TextField(question,this,rm);
			textfield.setName(question.getId());
			add(textfield);			
		}
		else
		{
			//TextField textfield = new TextField(question,this,showCondition,rm);
			TextField textfield = new TextField(question,this,rm);
			textfield.setName(question.getId());
			add(textfield);
		}
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public void checkVisibility(boolean visible)
    {
		setVisible(visible);
    }
}

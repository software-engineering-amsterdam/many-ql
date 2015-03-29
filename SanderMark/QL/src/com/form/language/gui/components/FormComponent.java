package com.form.language.gui.components;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.form.language.ast.Form;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Statement;
import com.form.language.ast.statement.question.Question;
import com.form.language.memory.Context;

public class FormComponent {

	private Expression ifCondition;
	
	private Form form;
	private JFrame frame;
	private JPanel panel;
	private Context context;

	public FormComponent(Form form, JFrame frame, Context context) {
		this.form = form;
		this.frame = frame;
		this.context = context;
		
    	this.panel = new JPanel();
    	this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
    	this.frame.add(this.panel);
	}
	
	public void createGUIComponents()
	{	
		for(Statement s : form.getStatements()){
			s.createGUIComponent(this, panel, context);
		}
	}	

	public void createGUIQuestion(Question question, JPanel panel, Context context) {
		QuestionComponent questionCompondent = new QuestionComponent(question, context, ifCondition);
		panel.add(questionCompondent.getPanel());
	}

	public void setIfCondition(Expression condition) {
		ifCondition = condition;
	}
}

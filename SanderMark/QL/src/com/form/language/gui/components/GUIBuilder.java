package com.form.language.gui.components;

import javax.swing.JFrame;

import com.form.language.ast.Form;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.ast.statement.Statement;
import com.form.language.memory.Context;

public class GUIBuilder {

	private FormComponent formGUI;
	private Expression ifCondition;
	
	private Form form;
	private JFrame frame;
	private Context context;

	public GUIBuilder(Form form, JFrame frame, Context context) {
		this.form = form;
		this.frame = frame;
		this.context = context;
	}
	
	public void createGUIForm()
	{
		formGUI = new FormComponent(form, this, frame);
		frame.add(formGUI.getPanel());
	}
	
	public void createGUIComponents()
	{	
		for(Statement s : form.getStatements()){
			s.createGUIComponent(this, formGUI, context);
		}
	}	

	public void createGUIQuestion(Question question, FormComponent formGUI2, Context context) {
		QuestionComponent questionCompondent = new QuestionComponent(question, context, ifCondition);
		formGUI2.getPanel().add(questionCompondent.getPanel());
	}

	public void setIfCondition(Expression condition) {
		ifCondition = condition;
	}
}

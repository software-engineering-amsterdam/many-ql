package com.form.language.gui.components;

import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import com.form.language.ast.Form;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.ast.statement.Statement;
import com.form.language.ast.type.Type;

public class GUIBuilder {
	
	private FormComponent formGUI;
	private Expression showCondition;
	
	public GUIBuilder(Form form,JFrame frame)
	{
		formGUI = new FormComponent(form,this,frame);	
		frame.add(formGUI);
		for(Iterator<Statement> s = form.statementList.iterator(); s.hasNext();)
		{
			Statement statement = s.next();
			statement.createGUIComponent(this,formGUI);
		}	
	}

	public void createGUIQuestion(Question question, FormComponent formGUI2) {
		QuestionComponent questionCompondent = new QuestionComponent(question,showCondition);	
		formGUI2.add(questionCompondent);
	}
	
	public void SetShowCondition(Expression condition)
    {
		showCondition = condition;
    }

    public void RemoveShowCondition()
    {
    	showCondition = null;
    }
	
	
	
	

}

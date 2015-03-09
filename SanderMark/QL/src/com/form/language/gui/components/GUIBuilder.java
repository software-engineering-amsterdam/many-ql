package com.form.language.gui.components;

import java.util.Iterator;

import javax.swing.JFrame;

import com.form.language.ast.Form;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.ast.statement.Statement;
import com.form.language.memory.RuntimeMemory;

public class GUIBuilder {
	
	private FormComponent formGUI;
	private RuntimeMemory rm;
	private Expression showCondition;
	
	public GUIBuilder(Form form,JFrame frame)
	{
		rm = form.initMemory();
		
		formGUI = new FormComponent(form,this,frame);	
		frame.add(formGUI);
		
		for(Iterator<Statement> s = form.statementList.iterator(); s.hasNext();)
		{
			Statement statement = s.next();
			
			//Hier mee geven, want deze komt uiteindelijk terug bij createGUI question etc.
			statement.createGUIComponent(this,formGUI,rm);
		}	
	}

	public void createGUIQuestion(Question question, FormComponent formGUI2, RuntimeMemory rm) {
		QuestionComponent questionCompondent = new QuestionComponent(question,rm,showCondition);	
		formGUI2.add(questionCompondent);
	}
	
	public void SetShowCondition(Expression condition)
    {
		showCondition = condition;
    }
	

}

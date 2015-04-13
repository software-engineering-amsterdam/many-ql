package com.form.language.ast.statement.question;

import javax.swing.JPanel;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.gui.components.FormComponent;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class ComputedQuestion extends Question {
	
	private Expression _expression;

	public ComputedQuestion(String label, String id, Type questionType, Expression expression, QLToken tokenInfo) {
		super(label, id, questionType, tokenInfo);
		// TODO Auto-generated constructor stub
		_expression = expression;
	}
	
	//Typechecker?
	
	
	@Override
	public void initMemory(Context context) 
	{
		context.setComputedValue(getId(), _expression);
	}
	
	@Override
    public void createGUIComponent(FormComponent guiBuilder, JPanel panel, Context context) {
		guiBuilder.createGUIQuestion(this, panel, context);
    }

}

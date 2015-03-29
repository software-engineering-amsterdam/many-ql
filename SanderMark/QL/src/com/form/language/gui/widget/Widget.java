package com.form.language.gui.widget;

import java.util.List;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.GenericValue;
import com.form.language.gui.components.QuestionComponent;
import com.form.language.memory.Context;

public abstract class Widget {
	
	private Question question;
	private Context context;
	
	public Widget(Question question,Context context)
	{
		this.question = question;	
		this.context = context;
	}
	
	public void setContextValue(GenericValue value) {
		context.setValue(question.getId(),value);
	}
	
	public void checkDependencyVisibility() {
		for (Expression exp : context.getReferencingExpressions(question.getId())){
			List<QuestionComponent> q = context.getDependantQuestions(exp);
			checkVisibilities(exp, q);
		}
	}

	public void checkVisibilities(Expression exp, List<QuestionComponent> q) {
		for (QuestionComponent question : q) {
			question.checkVisibility(((BoolValue) exp.evaluate(context)).getValue());
		}
	}

}

package com.form.language.gui.components;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.variable.ReferenceCollection;
import com.form.language.ast.statement.question.ComputedQuestion;
import com.form.language.ast.values.GenericValue;
import com.form.language.memory.Context;

public class ComputedQuestionComponent extends QuestionComponent {
	ComputedQuestion question;
	
	public ComputedQuestionComponent(ComputedQuestion question, Context context, Expression ifCondition) {
		super(question, context, ifCondition);
		
		this.question = question;
		
		//Collect references and add callbacks to this component at the references
		Expression computation = question.getExpression();
		ReferenceCollection references = new ReferenceCollection();
		computation.collectIds(references);
		context.addComputationCallbacks(references, this);
	}
	
	public void updateAndRedraw(Context context){
		GenericValue oldValue = context.getValue(question.getId());
		GenericValue newValue = question.getValue(context);
		
		//Only update and redraw if the value is changed
		if(!oldValue.equals(newValue)){
			context.setValue(question.getId(), question.getValue(context));
			redraw();
		}
		
	}

}

package com.form.language.gui.components;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.variable.ReferenceCollection;
import com.form.language.ast.statement.question.ComputedQuestion;
import com.form.language.ast.values.BoolValue;
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
		context.setValue(question.getId(), question.getValue(context));
		//Set value van zijn widget, of widget vraagt of die zichzelf update (widget/checkbox class) 
		question.getWidget.setValue(question.getValue(context));
		redraw();
	}

}

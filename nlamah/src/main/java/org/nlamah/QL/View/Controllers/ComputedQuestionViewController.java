package org.nlamah.QL.View.Controllers;

import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Form.Abstract.QuestionView;
import org.nlamah.QL.View.Widgets.ComputedValueWidgetView;

public class ComputedQuestionViewController extends QuestionViewController 
{
	public ComputedQuestionViewController(FormRootViewController rootViewController, FormQuestion question) 
	{
		super(rootViewController, question);
	}
	
	@Override
	public void valueChanged(ValueExpression newValue) 
	{		
		rootViewController.modelStateChanged();
	}
	
	private void adjustComputedValue()
	{
		FormQuestion question = (FormQuestion) modelElement;
		
		assert(question instanceof ComputedQuestion);
		
		ValueExpression value = ((ComputedQuestion) question).value();
		
		assert(view instanceof QuestionView);
		assert(((QuestionView) view).widgetView() instanceof ComputedValueWidgetView);
			
		ComputedValueWidgetView widgetView = (ComputedValueWidgetView)((QuestionView) view).widgetView();
			 
		widgetView.setValue(value);
	}
	
	@Override
	public int evaluateViewHeight() 
	{		
		adjustComputedValue();

		return super.evaluateViewHeight();
	}
}

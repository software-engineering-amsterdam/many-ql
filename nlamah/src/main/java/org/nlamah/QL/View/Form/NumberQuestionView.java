package org.nlamah.QL.View.Form;

import org.nlamah.QL.View.Form.Abstract.QuestionView;
import org.nlamah.QL.View.Form.Abstract.QuestionWidget;
import org.nlamah.QL.View.Form.Widgets.NumberWidget;

@SuppressWarnings("serial")
public class NumberQuestionView extends QuestionView
{	
	public NumberQuestionView(QuestionWidget widget) 
	{
		super(widget);
	}

	public void fillInNumberField(String number)
	{
		((NumberWidget) answerWidget).fillInNumberField(number);
	}
	
	@Override
	public void layoutView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComponentsToView() {
		// TODO Auto-generated method stub
		
	}
}

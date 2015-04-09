package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.BooleanQuestion;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.BooleanQuestionView;

public class BooleanQuestionViewController extends QuestionViewController 
{	
	public BooleanQuestionViewController(BooleanQuestion question)
	{
		view = new BooleanQuestionView(question);
		view.setFormElementListener(this);
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		parentViewController.modelStateChanged(formElement);	
	}
}

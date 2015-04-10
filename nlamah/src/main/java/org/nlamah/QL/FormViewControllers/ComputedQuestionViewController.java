package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.ComputedQuestion;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ComputedQuestionView;

public class ComputedQuestionViewController extends FormElementViewController 
{
	public ComputedQuestionViewController(ComputedQuestion question) 
	{
		super(question);
		
		setView(new ComputedQuestionView(question));
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
		
	}
}

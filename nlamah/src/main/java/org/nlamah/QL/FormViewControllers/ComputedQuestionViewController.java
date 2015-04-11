package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormModel.Question;
import org.nlamah.QL.FormModel.ComputedQuestion;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ComputedQuestionView;

public class ComputedQuestionViewController extends FormElementViewController 
{
	ComputedQuestionView questionView;
	
	public ComputedQuestionViewController(ComputedQuestion question) 
	{
		super(question);
		
		questionView = new ComputedQuestionView(this);
		
		questionView.fillInType(questionType());
		questionView.fillInQuestionString(questionString());
		
		setView(questionView);
	}
	
	private String questionType()
	{
		return ((Question) modelElement()).type();
	}
	
	private String questionString()
	{
		return ((Question) modelElement()).questionString();
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int preferredViewHeight() 
	{
		return view().getPreferredSize().height;
	}

	@Override
	public void viewNeedsUpdate() {
		// TODO Auto-generated method stub
		
	}
}

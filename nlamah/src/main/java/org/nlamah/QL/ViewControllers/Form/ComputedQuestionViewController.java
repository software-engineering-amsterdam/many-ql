package org.nlamah.QL.ViewControllers.Form;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.QuestionViewController;
import org.nlamah.QL.Views.Form.ComputedQuestionView;

public class ComputedQuestionViewController extends QuestionViewController 
{
	ComputedQuestionView questionView;
	
	public ComputedQuestionViewController(ComputedQuestion question) 
	{
		super(question);
		
		questionView = new ComputedQuestionView(this);
		
		questionView.fillInType(questionReturnType().name());
		questionView.fillInQuestionString(questionString());
		questionView.fillInComputedValueLabel(question.computedValue().toString());
		
		view = questionView;
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void viewNeedsUpdate() 
	{
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}
}

package org.nlamah.QL.ViewControllers.Form;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ComputedQuestion;
import org.nlamah.QL.ViewControllers.Form.Abstract.QuestionViewController;
import org.nlamah.QL.Views.Form.ComputedQuestionView;
import org.nlamah.QL.Views.Form.Widgets.ComputedValueWidget;

public class ComputedQuestionViewController extends QuestionViewController 
{
	ComputedQuestionView questionView;
	
	public ComputedQuestionViewController(ComputedQuestion question) 
	{
		super(question);
		
		ComputedValueWidget widget = new ComputedValueWidget();
		
		questionView = new ComputedQuestionView(widget);
		
		if (question.computedValue() != null)
		{
			questionView.fillInComputedValueLabel(question.computedValue().toString());
		}
		
		questionView.fillInQuestionString(questionString());
		
		view = questionView;
	}
	
	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}
	
	@Override
	public int neededViewHeight() 
	{
		return view.getPreferredSize().height;
	}
}

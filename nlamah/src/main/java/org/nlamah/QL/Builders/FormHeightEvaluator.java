package org.nlamah.QL.Builders;

import java.util.List;

import org.nlamah.QBase.Tools.ArrayTools;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.View.Controllers.ConditionalBlockViewController;
import org.nlamah.QL.View.Controllers.ElseIfThenBlockViewController;
import org.nlamah.QL.View.Controllers.ElseThenBlockViewController;
import org.nlamah.QL.View.Controllers.FormRootViewController;
import org.nlamah.QL.View.Controllers.IfThenBlockViewController;
import org.nlamah.QL.View.Controllers.QuestionViewController;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;

public class FormHeightEvaluator implements QLFormElementViewControllerVisitor 
{
	private int preferredHeight;
	private int currentlyCalculatedHeight;

	public int evaluate(List<FormElementViewController> formElementViewControllers)
	{
		preferredHeight = 0;

		if (ArrayTools.arrayExistsAndHasElements(formElementViewControllers))
		{
			for (FormElementViewController formElementViewController : formElementViewControllers)
			{
				formElementViewController.accept(this);
			}
		}

		return preferredHeight;
	}

	@Override
	public void visit(FormRootViewController FormRootViewController) 
	{
		assert(false);
	}

	@Override
	public void visit(QuestionViewController questionViewController)
	{
		questionViewController.view().layoutView();

		currentlyCalculatedHeight = questionViewController.evaluateViewHeight();

		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(ElseIfThenBlockViewController elseIfThenBlockViewController) 
	{
		currentlyCalculatedHeight = elseIfThenBlockViewController.evaluateViewHeight();

		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(ElseThenBlockViewController elseThenBlockViewController) 
	{
		currentlyCalculatedHeight = elseThenBlockViewController.evaluateViewHeight();

		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(IfThenBlockViewController ifThenBlockViewController) 
	{
		currentlyCalculatedHeight = ifThenBlockViewController.evaluateViewHeight();

		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(ConditionalBlockViewController conditionalBlockViewController) 
	{		
		currentlyCalculatedHeight = conditionalBlockViewController.evaluateViewHeight();

		preferredHeight += currentlyCalculatedHeight;
	}	
}
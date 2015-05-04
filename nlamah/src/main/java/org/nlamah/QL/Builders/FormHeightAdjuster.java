package org.nlamah.QL.Builders;

import java.util.List;

import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.View.Controllers.BooleanQuestionViewController;
import org.nlamah.QL.View.Controllers.ComputedQuestionViewController;
import org.nlamah.QL.View.Controllers.ConditionalBlockViewController;
import org.nlamah.QL.View.Controllers.ElseIfThenBlockViewController;
import org.nlamah.QL.View.Controllers.ElseThenBlockViewController;
import org.nlamah.QL.View.Controllers.FormRootViewController;
import org.nlamah.QL.View.Controllers.IfThenBlockViewController;
import org.nlamah.QL.View.Controllers.NumberQuestionViewController;
import org.nlamah.QL.View.Controllers.TextQuestionViewController;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;

public class FormHeightAdjuster implements QLFormElementViewControllerVisitor 
{
	private int preferredHeight;
	private int currentlyCalculatedHeight;
	
	public int getPreferredHeight(List<FormElementViewController> formElementViewControllers)
	{
		preferredHeight = 0;
		
		if (QBaseHelper.arrayExistsAndHasElements(formElementViewControllers))
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
		assert false;
	}

	@Override
	public void visit(BooleanQuestionViewController booleanQuestionViewController) 
	{
		currentlyCalculatedHeight = booleanQuestionViewController.neededViewHeight();
		
		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(ComputedQuestionViewController computedQuestionViewController) 
	{
		currentlyCalculatedHeight = computedQuestionViewController.neededViewHeight();
		
		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(NumberQuestionViewController numberQuestionViewController) 
	{
		currentlyCalculatedHeight = numberQuestionViewController.neededViewHeight();
		
		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(TextQuestionViewController textQuestionViewController) 
	{
		currentlyCalculatedHeight = textQuestionViewController.neededViewHeight();
		
		preferredHeight += currentlyCalculatedHeight;
	}
	
	@Override
	public void visit(ElseIfThenBlockViewController elseIfThenBlockViewController) 
	{
		currentlyCalculatedHeight = elseIfThenBlockViewController.neededViewHeight();
		
		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(ElseThenBlockViewController elseThenBlockViewController) 
	{
		currentlyCalculatedHeight = elseThenBlockViewController.neededViewHeight();
		
		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(IfThenBlockViewController ifThenBlockViewController) 
	{
		currentlyCalculatedHeight = ifThenBlockViewController.neededViewHeight();
		
		preferredHeight += currentlyCalculatedHeight;
	}

	@Override
	public void visit(ConditionalBlockViewController conditionalBlockViewController) 
	{
		currentlyCalculatedHeight = conditionalBlockViewController.neededViewHeight();
		
		preferredHeight += currentlyCalculatedHeight;
	}
}

package org.nlamah.QL.Views.Builders;

import java.util.ArrayList;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.ViewControllers.Form.BooleanQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.ComputedQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.ConditionalBlockViewController;
import org.nlamah.QL.ViewControllers.Form.ElseIfThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.ElseThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.FormRootViewController;
import org.nlamah.QL.ViewControllers.Form.IfThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.NumberQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.TextQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;

public class FormHeightAdjuster implements QLFormElementViewControllerVisitor 
{
	private int preferredHeight;
	private int currentlyCalculatedHeight;
	
	public int getPreferredHeight(ArrayList<FormElementViewController> formElementViewControllers)
	{
		preferredHeight = 0;
		
		for (FormElementViewController formElementViewController : formElementViewControllers)
		{
			formElementViewController.accept(this);
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

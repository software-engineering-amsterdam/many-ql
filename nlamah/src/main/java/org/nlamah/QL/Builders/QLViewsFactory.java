package org.nlamah.QL.Builders;

import java.util.ArrayList;

import org.nlamah.QL.Helper.QLHelper;
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
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.Views.Form.ElseThenBlockView;
import org.nlamah.QL.Views.Form.IfThenBlockView;
import org.nlamah.QL.Views.Form.ElseIfThenBlockView;
import org.nlamah.QL.Views.Form.Abstract.FormElementView;

public class QLViewsFactory implements QLFormElementViewControllerVisitor 
{
	private FormElementView currentlyCreatedView;

	public ArrayList<FormElementView> gatherChildViews(DeclaringFormElementViewController declaringFormElementViewController)
	{
		ArrayList<FormElementViewController> childViewControllers = declaringFormElementViewController.childViewControllers();
		ArrayList<FormElementView> childViews = null;
		
		if (QLHelper.arrayExistsAndHasElements(childViewControllers))
		{
			childViews = new ArrayList<FormElementView>(childViewControllers.size());
			
			for (FormElementViewController childViewController : childViewControllers)
			{
				childViewController.accept(this);
				
				childViews.add(currentlyCreatedView);
			}
		}
		
		return childViews;
	}
	
	private void gatherAndAddChildViews(DeclaringFormElementViewController viewController)
	{
		FormElementView view = viewController.view();
		
		viewController.setChildViews(gatherChildViews(viewController));
		
		if (QLHelper.arrayExistsAndHasElements(viewController.childViews()))
		{
			for (FormElementView childView : viewController.childViews())
			{
				view.add(childView);
			}
		}
		
		currentlyCreatedView = view;
	}
	
	private ConditionalBlockViewController addIfThenBlockView (ConditionalBlockViewController conditionalBlockViewController)
	{
		FormElementView conditionalBlockView = conditionalBlockViewController.view();
		
		IfThenBlockViewController ifThenBlockViewController = conditionalBlockViewController.ifThenBlockViewController();
		
		if (ifThenBlockViewController != null)
		{
			ifThenBlockViewController.accept(this);
			conditionalBlockViewController.setIfThenBlockView((IfThenBlockView) currentlyCreatedView);	
			conditionalBlockView.add(currentlyCreatedView);
		}
		
		return conditionalBlockViewController;
	}
	
	private ConditionalBlockViewController addElseIfThenBlockViews(ConditionalBlockViewController conditionalBlockViewController)
	{
		FormElementView conditionalBlockView = conditionalBlockViewController.view();
		
		ArrayList<ElseIfThenBlockViewController> elseIfThenBlockViewControllers = conditionalBlockViewController.elseIfThenBlockViewControllers();
		ArrayList<ElseIfThenBlockView> elseIfThenBlockViews = null;
		
		if (QLHelper.arrayExistsAndHasElements(elseIfThenBlockViewControllers))
		{
			elseIfThenBlockViews = new ArrayList<ElseIfThenBlockView>(elseIfThenBlockViewControllers.size());
			
			for (ElseIfThenBlockViewController elseIfThenBlockViewController : elseIfThenBlockViewControllers)
			{
				elseIfThenBlockViewController.accept(this);
				elseIfThenBlockViews.add((ElseIfThenBlockView) currentlyCreatedView);
				conditionalBlockView.add(currentlyCreatedView);
			}
		}
		
		conditionalBlockViewController.setElseIfThenBlockViews(elseIfThenBlockViews);
		
		return conditionalBlockViewController;
	}
	
	private ConditionalBlockViewController addElseThenBlockView(ConditionalBlockViewController conditionalBlockViewController)
	{
		FormElementView conditionalBlockView = conditionalBlockViewController.view();
		
		ElseThenBlockViewController elseThenBlockViewController = conditionalBlockViewController.elseThenBlockViewController();
		
		if (elseThenBlockViewController != null)
		{
			elseThenBlockViewController.accept(this);
			conditionalBlockViewController.setElseThenBlockView((ElseThenBlockView) currentlyCreatedView);
			conditionalBlockView.add(currentlyCreatedView);
		}
		
		return conditionalBlockViewController;
	}
	
	@Override
	public void visit(FormRootViewController FormRootViewController) 
	{
		assert false;
	}

	@Override
	public void visit(BooleanQuestionViewController booleanQuestionViewController) 
	{
		currentlyCreatedView = booleanQuestionViewController.view();
	}

	@Override
	public void visit(ComputedQuestionViewController computedQuestionViewController) 
	{
		currentlyCreatedView = computedQuestionViewController.view();
	}

	@Override
	public void visit(NumberQuestionViewController numberQuestionViewController) 
	{
		currentlyCreatedView = numberQuestionViewController.view();
	}

	@Override
	public void visit(TextQuestionViewController textQuestionViewController) 
	{
		currentlyCreatedView = textQuestionViewController.view();
	}

	@Override
	public void visit(ElseIfThenBlockViewController elseIfThenBlockViewController) 
	{
		gatherAndAddChildViews(elseIfThenBlockViewController);
	}

	@Override
	public void visit(ElseThenBlockViewController elseThenBlockViewController) 
	{
		gatherAndAddChildViews(elseThenBlockViewController);
	}

	@Override
	public void visit(IfThenBlockViewController ifThenBlockViewController) 
	{
		gatherAndAddChildViews(ifThenBlockViewController);
	}

	@Override
	public void visit(ConditionalBlockViewController conditionalBlockViewController) 
	{
		conditionalBlockViewController = addIfThenBlockView(conditionalBlockViewController);
		
		conditionalBlockViewController = addElseIfThenBlockViews(conditionalBlockViewController);
		
		conditionalBlockViewController = addElseThenBlockView(conditionalBlockViewController);
		
		currentlyCreatedView = conditionalBlockViewController.view();
	}
}

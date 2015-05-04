package org.nlamah.QL.Builders;

import java.util.ArrayList;
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
import org.nlamah.QL.View.Controllers.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QL.View.Form.ElseIfThenBlockView;
import org.nlamah.QL.View.Form.ElseThenBlockView;
import org.nlamah.QL.View.Form.IfThenBlockView;
import org.nlamah.QL.View.Form.Abstract.FormElementView;

public class QLViewsFactory implements QLFormElementViewControllerVisitor 
{
	private FormElementView currentlyCreatedView;

	public List<FormElementView> gatherChildViews(DeclaringFormElementViewController declaringFormElementViewController)
	{
		List<FormElementViewController> childViewControllers = declaringFormElementViewController.childViewControllers();
		List<FormElementView> childViews = null;
		
		if (QBaseHelper.arrayExistsAndHasElements(childViewControllers))
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
	
	public FormElementView gatherViewForFormViewController(FormElementViewController formViewController)
	{
		formViewController.accept(this);
		
		return currentlyCreatedView;
	}
	
	private void gatherAndAddChildViews(DeclaringFormElementViewController viewController)
	{
		FormElementView view = viewController.view();
		
		viewController.setChildViews(gatherChildViews(viewController));
		
		if (QBaseHelper.arrayExistsAndHasElements(viewController.childViews()))
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
		
		List<ElseIfThenBlockViewController> elseIfThenBlockViewControllers = conditionalBlockViewController.elseIfThenBlockViewControllers();
		List<ElseIfThenBlockView> elseIfThenBlockViews = null;
		
		if (QBaseHelper.arrayExistsAndHasElements(elseIfThenBlockViewControllers))
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

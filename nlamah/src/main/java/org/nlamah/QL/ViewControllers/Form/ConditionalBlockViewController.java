package org.nlamah.QL.ViewControllers.Form;

import java.util.ArrayList;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.Views.Form.ConditionalBlockView;
import org.nlamah.QL.Views.Form.ElseIfThenBlockView;
import org.nlamah.QL.Views.Form.ElseThenBlockView;
import org.nlamah.QL.Views.Form.IfThenBlockView;

public abstract class ConditionalBlockViewController extends FormElementViewController 
{
	protected ConditionalBlockView conditionalBlockView;
	
	protected IfThenBlockViewController ifThenBlockViewController;
	protected ArrayList<ElseIfThenBlockViewController> elseIfThenBlockViewControllers;
	protected ElseThenBlockViewController elseThenBlockViewController;

	protected IfThenBlockView ifThenBlockView;
	protected ArrayList<ElseIfThenBlockView> elseIfThenBlockViews;
	protected ElseThenBlockView elseThenBlockView;

	public ConditionalBlockViewController(ConditionalBlock conditionalBlock)
	{
		super(conditionalBlock);
		
		conditionalBlockView = new ConditionalBlockView(this);
		
		view = conditionalBlockView;
	}
	
	public IfThenBlockViewController ifThenBlockViewController() 
	{
		return ifThenBlockViewController;
	}

	public void setIfThenBlockViewController(IfThenBlockViewController ifThenBlockViewController) 
	{
		this.ifThenBlockViewController = ifThenBlockViewController;
	}

	public ArrayList<ElseIfThenBlockViewController> elseIfThenBlockViewControllers() 
	{
		return elseIfThenBlockViewControllers;
	}

	public void setElseIfThenBlockViewControllers(ArrayList<ElseIfThenBlockViewController> elseIfThenBlockViewControllers) 
	{
		this.elseIfThenBlockViewControllers = elseIfThenBlockViewControllers;
	}

	public ElseThenBlockViewController elseThenBlockViewController()
	{
		return elseThenBlockViewController;
	}

	public void setElseThenBlockViewController(ElseThenBlockViewController elseThenBlockViewController) 
	{
		this.elseThenBlockViewController = elseThenBlockViewController;
	}


	public void setIfThenBlockView(IfThenBlockView ifThenBlockView) 
	{
		this.ifThenBlockView = ifThenBlockView;
	}
	
	public void setElseIfThenBlockViews(ArrayList<ElseIfThenBlockView> elseIfThenBlockViews) 
	{
		this.elseIfThenBlockViews = elseIfThenBlockViews;
	}

	public void setElseThenBlockView(ElseThenBlockView elseThenBlockView) 
	{
		this.elseThenBlockView = elseThenBlockView;
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

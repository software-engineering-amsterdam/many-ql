package org.nlamah.QL.View.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QL.View.Form.ConditionalBlockView;
import org.nlamah.QL.View.Form.ElseIfThenBlockView;
import org.nlamah.QL.View.Form.ElseThenBlockView;
import org.nlamah.QL.View.Form.IfThenBlockView;

public abstract class ConditionalBlockViewController extends FormElementViewController 
{
	protected IfThenBlockViewController ifThenBlockViewController;
	protected List<ElseIfThenBlockViewController> elseIfThenBlockViewControllers;
	protected ElseThenBlockViewController elseThenBlockViewController;

	private IfThenBlockView ifThenBlockView;
	private List<ElseIfThenBlockView> elseIfThenBlockViews;
	private ElseThenBlockView elseThenBlockView;

	public ConditionalBlockViewController(ConditionalBlock conditionalBlock)
	{
		super(conditionalBlock);

		view = new ConditionalBlockView();
	}

	public IfThenBlockViewController ifThenBlockViewController() 
	{
		return ifThenBlockViewController;
	}

	public void setIfThenBlockViewController(IfThenBlockViewController ifThenBlockViewController) 
	{
		this.ifThenBlockViewController = ifThenBlockViewController;
	}

	public List<ElseIfThenBlockViewController> elseIfThenBlockViewControllers() 
	{
		if (elseIfThenBlockViewControllers == null)
		{
			return new ArrayList<ElseIfThenBlockViewController>();
		}

		return elseIfThenBlockViewControllers;
	}

	public void setElseIfThenBlockViewControllers(List<ElseIfThenBlockViewController> elseIfThenBlockViewControllers) 
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

	public IfThenBlockView ifThenBlockView() 
	{	
		return ifThenBlockView;
	}

	public void setElseIfThenBlockViews(List<ElseIfThenBlockView> elseIfThenBlockViews) 
	{
		this.elseIfThenBlockViews = elseIfThenBlockViews;
	}

	public List<ElseIfThenBlockView> elseIfThenBlockViews()
	{
		return elseIfThenBlockViews;
	}

	public void setElseThenBlockView(ElseThenBlockView elseThenBlockView) 
	{
		this.elseThenBlockView = elseThenBlockView;
	}

	public ElseThenBlockView elseThenBlockView()
	{
		return elseThenBlockView;
	}

	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}
}

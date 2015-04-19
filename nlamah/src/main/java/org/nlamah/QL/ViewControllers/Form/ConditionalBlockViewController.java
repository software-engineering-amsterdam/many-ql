package org.nlamah.QL.ViewControllers.Form;

import java.awt.Dimension;
import java.util.ArrayList;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.Views.Form.ConditionalBlockView;
import org.nlamah.QL.Views.Form.ElseIfThenBlockView;
import org.nlamah.QL.Views.Form.ElseThenBlockView;
import org.nlamah.QL.Views.Form.IfThenBlockView;

public class ConditionalBlockViewController extends FormElementViewController 
{
	private ConditionalBlockView conditionalBlockView;
	
	private IfThenBlockViewController ifThenBlockViewController;
	private ArrayList<ElseIfThenBlockViewController> elseIfThenBlockViewControllers;
	private ElseThenBlockViewController elseThenBlockViewController;

	private IfThenBlockView ifThenBlockView;
	private ArrayList<ElseIfThenBlockView> elseIfThenBlockViews;
	private ElseThenBlockView elseThenBlockView;

	
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
	
	private boolean ifThenBlockExists()
	{
		ConditionalBlock conditionalBlock = (ConditionalBlock) modelElement;
		
		return conditionalBlock.ifThenBlock() != null;
	}
	
	private boolean elseIfThenBlocksExist()
	{
		ConditionalBlock conditionalBlock = (ConditionalBlock) modelElement;
		
		return Helper.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks());
	}
	
	private boolean elseThenBlockExists()
	{
		ConditionalBlock conditionalBlock = (ConditionalBlock) modelElement;
		
		return conditionalBlock.elseThenBlock() != null;
	}
	
	private void makeAllViewsInvisible()
	{
		if (ifThenBlockExists())
		{
			ifThenBlockView.setVisible(false);
		}
		
		if (elseIfThenBlocksExist())
		{
			for (ElseIfThenBlockView elseIfThenBlockView : elseIfThenBlockViews)
			{
				elseIfThenBlockView.setVisible(false);
			}
		}
		
		if (elseThenBlockExists())
		{
			elseThenBlockView.setVisible(false);
		}
	}
	
	public void adjustViewHeightToNeededHeight(int neededHeight)
	{
		conditionalBlockView.setPreferredSize(new Dimension(Helper.contentWidth(), neededHeight));
	}

	@Override
	public int neededViewHeight() 
	{	
		makeAllViewsInvisible();

		
		if (ifThenBlockExists() && elseIfThenBlocksExist() && elseThenBlockExists())
		{
			if (ifThenBlockViewController.viewShouldBeVisible())
			{
				ifThenBlockView.setVisible(true);
				
				int neededHeight = ifThenBlockViewController.neededViewHeight();
				
				adjustViewHeightToNeededHeight(neededHeight);
				
				return neededHeight;
			}
			else
			{
				for (ElseIfThenBlockViewController elseIfThenBlockViewController : elseIfThenBlockViewControllers)
				{
					if (elseIfThenBlockViewController.shouldBeVisisble())
					{
						int index = elseIfThenBlockViewControllers.indexOf(elseIfThenBlockViewController);
						
						ElseIfThenBlockView elseIfThenBlockView = elseIfThenBlockViews.get(index);
						
						elseIfThenBlockView.setVisible(true);
						
						int neededHeight = elseIfThenBlockViewController.neededViewHeight();
						
						adjustViewHeightToNeededHeight(neededHeight);
						
						return neededHeight;
					}
				}
				
				elseThenBlockView.setVisible(true);
				
				int neededHeight = elseThenBlockViewController.neededViewHeight();
				
				adjustViewHeightToNeededHeight(neededHeight);
				
				return neededHeight;
			}
		}
		
		if (ifThenBlockExists() && !elseIfThenBlocksExist() && elseThenBlockExists())
		{
			if (ifThenBlockViewController.viewShouldBeVisible())
			{
				ifThenBlockView.setVisible(true);
				
				int neededHeight = ifThenBlockViewController.neededViewHeight();
				
				adjustViewHeightToNeededHeight(neededHeight);
				
				return neededHeight;
			}
			else
			{
				elseThenBlockView.setVisible(true);
				
				int neededHeight = elseThenBlockViewController.neededViewHeight();
				
				adjustViewHeightToNeededHeight(neededHeight);
				
				return neededHeight;
			}
		}
		
		if (ifThenBlockExists() && elseIfThenBlocksExist() && !elseThenBlockExists())
		{
			if (ifThenBlockViewController.viewShouldBeVisible())
			{
				ifThenBlockView.setVisible(true);
				
				int neededHeight = ifThenBlockViewController.neededViewHeight();
				
				adjustViewHeightToNeededHeight(neededHeight);
				
				return neededHeight;
			}
			else
			{
				for (ElseIfThenBlockViewController elseIfThenBlockViewController : elseIfThenBlockViewControllers)
				{
					if (elseIfThenBlockViewController.shouldBeVisisble())
					{
						int index = elseIfThenBlockViewControllers.indexOf(elseIfThenBlockViewController);
						
						ElseIfThenBlockView elseIfThenBlockView = elseIfThenBlockViews.get(index);
						
						elseIfThenBlockView.setVisible(true);
						
						int neededHeight = elseIfThenBlockViewController.neededViewHeight();
						
						adjustViewHeightToNeededHeight(neededHeight);
						
						return neededHeight;
					}
				}
				
				int neededHeight = 0;
				
				adjustViewHeightToNeededHeight(neededHeight);
				
				return neededHeight;
			}
		}
		
		if (ifThenBlockExists() && !elseIfThenBlocksExist() && !elseThenBlockExists())
		{
			if (ifThenBlockViewController.viewShouldBeVisible())
			{
				ifThenBlockView.setVisible(true);
				
				int neededHeight = ifThenBlockViewController.neededViewHeight();
				
				adjustViewHeightToNeededHeight(neededHeight);
				
				return neededHeight;
			}
			else
			{
				int neededHeight = 0;
				
				adjustViewHeightToNeededHeight(neededHeight);
				
				return neededHeight;
			}
		}
		
		if (!ifThenBlockExists() && !elseIfThenBlocksExist() && !elseThenBlockExists())
		{
			assert false;
		}
		
		if (!ifThenBlockExists() && (elseIfThenBlocksExist() || elseThenBlockExists()))
		{
			assert false;
		}
		
		int neededHeight = 0;
		
		adjustViewHeightToNeededHeight(neededHeight);
		
		return neededHeight;
	}
}

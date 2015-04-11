package org.nlamah.QL.FormViewControllers;

import java.awt.Dimension;
import java.util.ArrayList;

import org.nlamah.QL.FormModel.ConditionalBlock;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ConditionalBlockView;
import org.nlamah.QL.FormViews.ElseIfThenBlockView;
import org.nlamah.QL.FormViews.ElseThenBlockView;
import org.nlamah.QL.FormViews.FormElementView;
import org.nlamah.QL.FormViews.IfThenBlockView;
import org.nlamah.QL.Helper.Helper;

public class ConditionalBlockViewController extends FormElementViewController 
{
	private ConditionalBlockView conditionalBlockView;
	
	private IfThenBlockViewController ifThenBlockViewController;
	private ArrayList<ElseIfThenBlockViewController> elseIfThenBlockViewControllers;
	private ElseThenBlockViewController elseThenBlockViewController;

	private IfThenBlockView ifThenBlockView;
	private ArrayList<ElseIfThenBlockView> elseIfThenBlockViews;
	private ElseThenBlockView elseThenBlockView;
	
	private int preferredViewHeight;
	
	public ConditionalBlockViewController(ConditionalBlock conditionalBlock)
	{
		super(conditionalBlock);
		
		conditionalBlockView = new ConditionalBlockView(this);
		
		createChildViewControllers();
		createChildViews();
		
		addChildViewsToView();
		
		setView(conditionalBlockView);
		
		redrawChildViews();
	}

	private void createChildViewControllers()
	{
		ConditionalBlock conditionalBlock = (ConditionalBlock) modelElement();
		
		ifThenBlockViewController = (IfThenBlockViewController) (conditionalBlock.ifThenBlock() != null ? conditionalBlock.ifThenBlock().viewController() : null);
		
		if (Helper.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks()))
		{
			int numberOfElseIfThenViewControllers = conditionalBlock.elseIfThenBlocks().size();
			
			elseIfThenBlockViewControllers = new ArrayList<ElseIfThenBlockViewController>(numberOfElseIfThenViewControllers);
			
			for (int i = 0; i < numberOfElseIfThenViewControllers; i++)
			{
				elseIfThenBlockViewControllers.add((ElseIfThenBlockViewController) conditionalBlock.elseIfThenBlocks().get(i).viewController());
			}
		}
		
		elseThenBlockViewController = (ElseThenBlockViewController) (conditionalBlock.elseThenBlock() != null ? conditionalBlock.elseThenBlock().viewController() : null);
	}
	
	private void createChildViews()
	{
		ConditionalBlock conditionalBlock = (ConditionalBlock) modelElement();
		
		ifThenBlockView = (IfThenBlockView) (ifThenBlockViewController != null ? ifThenBlockViewController.view() : null);

		if (Helper.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks()))
		{
			int numberOfElseIfThenViews = conditionalBlock.elseIfThenBlocks().size();
			
			elseIfThenBlockViews = new ArrayList<ElseIfThenBlockView>(numberOfElseIfThenViews);
			
			for (int i = 0; i < numberOfElseIfThenViews; i++)
			{
				elseIfThenBlockViews.add((ElseIfThenBlockView) elseIfThenBlockViewControllers.get(i).view());
			}
		}
		
		elseThenBlockView = (ElseThenBlockView) (elseThenBlockViewController != null ? elseThenBlockViewController.view() : null);
	}
	
	private void addChildViewsToView()
	{
		int preferredHeight = 0;
		
		if (ifThenBlockView != null)
		{
			conditionalBlockView.add(ifThenBlockView);
			preferredHeight += ifThenBlockView.getPreferredSize().height;
		}
		
		if (Helper.arrayExistsAndHasElements(elseIfThenBlockViews))
		{
			for (int i = 0; i < elseIfThenBlockViews.size(); i++)
			{
				FormElementView formElementView = elseIfThenBlockViews.get(i);
				
				conditionalBlockView.add(formElementView);			
				preferredHeight += formElementView.getPreferredSize().height;
			}
		}
		
		if (elseThenBlockView != null)
		{
			conditionalBlockView.add(elseThenBlockView);
			preferredHeight += elseThenBlockView.getPreferredSize().height;
		}
		
		conditionalBlockView.setPreferredSize(new Dimension(Helper.contentWidth(), preferredHeight));
	}
	
	private void setViewHeight(int preferredViewHeight)
	{
		this.preferredViewHeight = preferredViewHeight;
		
		view().setVisible(true);
		
		view().setPreferredSize(new Dimension(Helper.contentWidth(), preferredViewHeight));
	}
	
	private void redrawChildViews()
	{
		makeAllViewsInvisible();
		
		if (ifThenBlockViewController != null && ifThenBlockViewController.viewShouldBeVisisble())
		{
			ifThenBlockView.setVisible(true);
			
			setViewHeight(ifThenBlockView.getPreferredSize().height);
			
			return;
		}
		
		if (Helper.arrayExistsAndHasElements(elseIfThenBlockViewControllers))
		{
			for (int i = 0; i < elseIfThenBlockViewControllers.size(); i++)
			{
				ElseIfThenBlockViewController viewController = elseIfThenBlockViewControllers.get(i);
				
				if (viewController.viewShouldBeVisisble())
				{
					ElseIfThenBlockView blockView = elseIfThenBlockViews.get(i);
					
					blockView.setVisible(true);
					
					setViewHeight(blockView.getPreferredSize().height);
					
					return;
				}
			}
		}
		
		if (elseThenBlockViewController != null)
		{
			elseThenBlockView.setVisible(true);
			
			setViewHeight(elseThenBlockView.getPreferredSize().height);
		}
		else
		{
			view().setVisible(false);
			
			setViewHeight(0);
		}
	}
	
	private void makeAllViewsInvisible()
	{
		view().setVisible(false);
		
		if (ifThenBlockView != null)
		{
			ifThenBlockView.setVisible(false);
		}
		
		if (Helper.arrayExistsAndHasElements(elseIfThenBlockViews))
		{
			for (ElseIfThenBlockView blockView : elseIfThenBlockViews)
			{
				blockView.setVisible(false);
			}
		}
		
		if (elseThenBlockView != null)
		{
			elseThenBlockView.setVisible(false);
		}
	}
	
	@Override
	public void modelStateChanged(FormElement formElement) 
	{		
		redrawChildViews();	
	}

	@Override
	int preferredViewHeight() 
	{
		return preferredViewHeight;
	}
}

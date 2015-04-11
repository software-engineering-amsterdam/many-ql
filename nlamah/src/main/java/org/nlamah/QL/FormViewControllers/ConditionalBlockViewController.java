package org.nlamah.QL.FormViewControllers;

import java.awt.Dimension;
import java.util.ArrayList;

import org.nlamah.QL.FormModel.ConditionalBlock;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ConditionalBlockView;
import org.nlamah.QL.FormViews.FormElementView;

public class ConditionalBlockViewController extends FormElementViewController 
{
	private ConditionalBlock conditionalBlock;
	private ConditionalBlockView conditionalBlockView;
	
	private FormElementViewController ifThenBlockViewController;
	private ArrayList<FormElementViewController> elseIfThenBlockViewControllers;
	private FormElementViewController elseThenBlockViewController;

	private FormElementView ifThenBlockView;
	private ArrayList<FormElementView> elseIfThenBlockViews;
	private FormElementView elseThenBlockView;
	
	public ConditionalBlockViewController(ConditionalBlock conditionalBlock)
	{
		super(conditionalBlock);
		
		this.conditionalBlock = conditionalBlock;
		conditionalBlockView = new ConditionalBlockView(conditionalBlock);
		
		createChildViewControllers();
		createChildViews();
		
		addChildViewsToView();
		
		setView(conditionalBlockView);
	}

	private void createChildViewControllers()
	{
		ifThenBlockViewController = conditionalBlock.ifThenBlock() != null ? conditionalBlock.ifThenBlock().createViewController() : null;
		
		if (conditionalBlock.elseIfThenBlocks() != null && conditionalBlock.elseIfThenBlocks().size() > 0)
		{
			int numberOfElseIfThenViewControllers = conditionalBlock.elseIfThenBlocks().size();
			
			elseIfThenBlockViewControllers = new ArrayList<FormElementViewController>(numberOfElseIfThenViewControllers);
			
			for (int i = 0; i < numberOfElseIfThenViewControllers; i++)
			{
				elseIfThenBlockViewControllers.add(conditionalBlock.elseIfThenBlocks().get(i).createViewController());
			}
		}
		
		elseThenBlockViewController = conditionalBlock.elseThenBlock() != null ? conditionalBlock.elseThenBlock().createViewController() : null;
	}
	
	private void createChildViews()
	{
		ifThenBlockView = ifThenBlockViewController != null ? ifThenBlockViewController.view() : null;

		if (conditionalBlock.elseIfThenBlocks() != null && conditionalBlock.elseIfThenBlocks().size() > 0)
		{
			int numberOfElseIfThenViews = conditionalBlock.elseIfThenBlocks().size();
			
			elseIfThenBlockViews = new ArrayList<FormElementView>(numberOfElseIfThenViews);
			
			for (int i = 0; i < numberOfElseIfThenViews; i++)
			{
				elseIfThenBlockViews.add(elseIfThenBlockViewControllers.get(i).view());
			}
		}
		
		elseThenBlockView = elseThenBlockViewController != null ? elseThenBlockViewController.view() : null;
	}
	
	private void addChildViewsToView()
	{
		int preferredHeight = 0;
		
		if (ifThenBlockView != null)
		{
			conditionalBlockView.add(ifThenBlockView);
			preferredHeight += ifThenBlockView.getPreferredSize().height;
		}
		
		if (elseIfThenBlockViews != null && elseIfThenBlockViews.size() > 0)
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
		
		conditionalBlockView.setPreferredSize(new Dimension(500, preferredHeight));
	}
	
	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
		
	}
}

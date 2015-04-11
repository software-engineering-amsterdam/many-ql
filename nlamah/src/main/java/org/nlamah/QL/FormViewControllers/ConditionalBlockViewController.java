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
import org.nlamah.QL.Helper.ArrayListHelper;

public class ConditionalBlockViewController extends FormElementViewController 
{
	private ConditionalBlock conditionalBlock;
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
		
		this.conditionalBlock = conditionalBlock;
		conditionalBlockView = new ConditionalBlockView(this);
		
		createChildViewControllers();
		createChildViews();
		
		addChildViewsToView();
		
		setView(conditionalBlockView);
	}

	private void createChildViewControllers()
	{
		ifThenBlockViewController = (IfThenBlockViewController) (conditionalBlock.ifThenBlock() != null ? conditionalBlock.ifThenBlock().createViewController() : null);
		
		if (ArrayListHelper.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks()))
		{
			int numberOfElseIfThenViewControllers = conditionalBlock.elseIfThenBlocks().size();
			
			elseIfThenBlockViewControllers = new ArrayList<ElseIfThenBlockViewController>(numberOfElseIfThenViewControllers);
			
			for (int i = 0; i < numberOfElseIfThenViewControllers; i++)
			{
				elseIfThenBlockViewControllers.add((ElseIfThenBlockViewController) conditionalBlock.elseIfThenBlocks().get(i).createViewController());
			}
		}
		
		elseThenBlockViewController = (ElseThenBlockViewController) (conditionalBlock.elseThenBlock() != null ? conditionalBlock.elseThenBlock().createViewController() : null);
	}
	
	private void createChildViews()
	{
		ifThenBlockView = (IfThenBlockView) (ifThenBlockViewController != null ? ifThenBlockViewController.view() : null);

		if (ArrayListHelper.arrayExistsAndHasElements(conditionalBlock.elseIfThenBlocks()))
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
		
		if (ArrayListHelper.arrayExistsAndHasElements(elseIfThenBlockViews))
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

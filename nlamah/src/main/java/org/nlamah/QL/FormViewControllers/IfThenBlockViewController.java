package org.nlamah.QL.FormViewControllers;

import java.awt.Dimension;

import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.IfThenBlock;
import org.nlamah.QL.FormViews.IfThenBlockView;
import org.nlamah.QL.Helper.Helper;

public class IfThenBlockViewController extends FormElementViewController 
{
	private IfThenBlockView ifThenBlockView;
	
	private int preferredViewHeight;
	
	public IfThenBlockViewController(IfThenBlock ifThenBlock) 
	{
		super(ifThenBlock);
		
		ifThenBlockView = new IfThenBlockView(this);
		
		setView(ifThenBlockView);
		
		if (Helper.arrayExistsAndHasElements(childViewControllers()))
		{	
			addChildComponents();
		}
	}
	
	public boolean viewShouldBeVisisble()
	{
		return ((IfThenBlock)modelElement()).isSatisfied();
	}
	
	private void addChildComponents()
	{
		preferredViewHeight = 0;
		
		for (int i = 0; i < childViewControllers().size(); i++)
		{
			FormElementViewController childViewController = childViewControllers().get(i);
			
			ifThenBlockView.add(childViewController.view());
			
			preferredViewHeight += childViewController.preferredViewHeight();
		}
		
		view().setPreferredSize(new Dimension(Helper.contentWidth(), preferredViewHeight));
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public int preferredViewHeight() 
	{
		preferredViewHeight = 0;
		
		for (int i = 0; i < childViewControllers().size(); i++)
		{
			FormElementViewController childViewController = childViewControllers().get(i);
			
			preferredViewHeight += childViewController.preferredViewHeight();
		}
		
		return preferredViewHeight;
	}

	@Override
	public void viewNeedsUpdate() 
	{
		// TODO Auto-generated method stub
	}
}

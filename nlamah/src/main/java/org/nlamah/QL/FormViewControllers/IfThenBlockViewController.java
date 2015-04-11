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
			System.out.println("the if then block view controller has " + childViewControllers().size() + " elements");
			
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
		
		System.out.println("preferredHeight: " + preferredViewHeight);
		
		view().setPreferredSize(new Dimension(Helper.contentWidth(), preferredViewHeight));
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	int preferredViewHeight() 
	{
		return preferredViewHeight;
	}
}

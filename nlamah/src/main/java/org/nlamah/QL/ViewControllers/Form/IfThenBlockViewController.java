package org.nlamah.QL.ViewControllers.Form;

import java.awt.Dimension;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Form.IfThenBlock;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.Views.Form.IfThenBlockView;

public class IfThenBlockViewController extends DeclaringFormElementViewController 
{
	private IfThenBlockView ifThenBlockView;
	
	private int preferredViewHeight;
	
	public IfThenBlockViewController(IfThenBlock ifThenBlock) 
	{
		super(ifThenBlock);
		
		ifThenBlockView = new IfThenBlockView(this);
		
		view = ifThenBlockView;
		
		if (Helper.arrayExistsAndHasElements(childViewControllers()))
		{	
			addChildComponents();
		}
	}
	
	public boolean viewShouldBeVisisble()
	{
		return ((IfThenBlock) modelElement).isSatisfied();
	}
	
	private void addChildComponents()
	{	
		for (int i = 0; i < childViewControllers().size(); i++)
		{
			FormElementViewController childViewController = childViewControllers().get(i);
			
			ifThenBlockView.add(childViewController.view());
		}
		
		view.setPreferredSize(new Dimension(Helper.contentWidth(), preferredViewHeight()));
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
		
		if (Helper.arrayExistsAndHasElements(childViewControllers()))
		{
			for (int i = 0; i < childViewControllers().size(); i++)
			{
				FormElementViewController childViewController = childViewControllers().get(i);
				
				preferredViewHeight += childViewController.preferredViewHeight();
			}
		}
		
		return preferredViewHeight;
	}

	@Override
	public void viewNeedsUpdate() 
	{
		// TODO Auto-generated method stub
	}
}

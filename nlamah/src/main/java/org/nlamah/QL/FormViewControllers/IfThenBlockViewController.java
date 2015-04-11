package org.nlamah.QL.FormViewControllers;

import java.awt.Dimension;

import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.IfThenBlock;
import org.nlamah.QL.FormViews.IfThenBlockView;
import org.nlamah.QL.Helper.ArrayListHelper;

public class IfThenBlockViewController extends FormElementViewController 
{
	private IfThenBlockView ifThenBlockView;
	
	public IfThenBlockViewController(IfThenBlock ifThenBlock) 
	{
		super(ifThenBlock);
		
		ifThenBlockView = new IfThenBlockView(ifThenBlock);
		
		if (ArrayListHelper.arrayExistsAndHasElements(childViewControllers()))
		{
			addChildComponents();
		}
		
		setView(ifThenBlockView);
	}
	
	private void addChildComponents()
	{
		int preferredHeight = 0;
		
		for (int i = 0; i < childViewControllers().size(); i++)
		{
			FormElementViewController childViewController = childViewControllers().get(i);
			
			ifThenBlockView.add(childViewController.view());
			
			preferredHeight += childViewController.view().getPreferredSize().height;
		}
		
		ifThenBlockView.setPreferredSize(new Dimension(500, preferredHeight));
		
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub
	}
}

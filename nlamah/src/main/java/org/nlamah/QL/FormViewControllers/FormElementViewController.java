package org.nlamah.QL.FormViewControllers;

import org.nlamah.QL.FormViews.FormElementView;

public abstract class FormElementViewController implements FormElementListener
{
	protected FormElementView view;
	protected FormElementViewController parentViewController;
	
	public FormElementViewController()
	{
		super();
	}
	
	public FormElementView view()
	{
		return this.view;
	}
	
	public FormElementViewController getParentViewController() 
	{
		return parentViewController;
	}

	public void setParentViewController(FormElementViewController parentViewController) 
	{
		this.parentViewController = parentViewController;
	}
}

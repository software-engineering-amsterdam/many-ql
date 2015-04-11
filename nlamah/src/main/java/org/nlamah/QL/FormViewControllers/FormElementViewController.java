package org.nlamah.QL.FormViewControllers;

import java.util.ArrayList;

import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.FormElementView;
import org.nlamah.QL.Helper.Helper;

public abstract class FormElementViewController implements FormElementListener
{
	private FormElement modelElement;
	private FormElementView view;
	private FormElementViewController parentViewController;
	
	private ArrayList<FormElementViewController> childViewControllers;
	
	public FormElementViewController(FormElement modelElement)
	{
		super();
		
		this.modelElement = modelElement;
	}

	public FormElement modelElement()
	{
		return this.modelElement;
	}
	
	public FormElementView view()
	{
		return this.view;
	}
	
	public void setView(FormElementView view)
	{
		this.view = view;
	}
	
	public FormElementViewController parentViewController() 
	{
		return parentViewController;
	}

	public void setParentViewController(FormElementViewController parentViewController) 
	{
		this.parentViewController = parentViewController;
	}
	
	public ArrayList<FormElementViewController> childViewControllers()
	{
		if (Helper.arrayExistsAndHasElements(modelElement.childElements()) && !Helper.arrayExistsAndHasElements(childViewControllers))
		{
			createChildViewControllers();
		}
		
		return this.childViewControllers;
	}
	
	abstract public int preferredViewHeight();
	
	private void createChildViewControllers()
	{
		int numberOfChildViewControllers = modelElement.childElements().size();
		
		ArrayList<FormElementViewController> childViewControllers= new ArrayList<FormElementViewController>(numberOfChildViewControllers);
		
		for (int i = 0; i < numberOfChildViewControllers; i++)
		{
			FormElement childElement = modelElement().childElements().get(i);
			FormElementViewController childViewController = childElement.viewController();
			childViewController.setParentViewController(this);
			childViewControllers.add(childViewController);
		}
		
		this.childViewControllers = childViewControllers;
	}
}

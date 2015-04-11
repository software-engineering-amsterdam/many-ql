package org.nlamah.QL.FormViewControllers;

import java.util.ArrayList;

import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.FormElementView;
import org.nlamah.QL.Helper.ArrayListHelper;

public abstract class FormElementViewController implements FormElementListener
{
	private FormElement formElement;
	private FormElementView view;
	private FormElementViewController parentViewController;
	
	private ArrayList<FormElementViewController> childViewControllers;
	
	public FormElementViewController(FormElement formElement)
	{
		super();
		
		this.formElement = formElement;
	}

	public FormElement formElement()
	{
		return this.formElement;
	}
	
	public FormElementView view()
	{
		return this.view;
	}
	
	public void setView(FormElementView view)
	{
		this.view = view;
	}
	
	public FormElementViewController getParentViewController() 
	{
		return parentViewController;
	}

	public void setParentViewController(FormElementViewController parentViewController) 
	{
		this.parentViewController = parentViewController;
	}
	
	public ArrayList<FormElementViewController> childViewControllers()
	{
		if (ArrayListHelper.arrayExistsAndHasElements(formElement.childElements()) && !ArrayListHelper.arrayExistsAndHasElements(childViewControllers))
		{
			createChildViewControllers();
		}
		
		return this.childViewControllers;
	}
	
	private void createChildViewControllers()
	{
		int numberOfChildViewControllers = formElement.childElements().size();
		
		ArrayList<FormElementViewController> childViewControllers= new ArrayList<FormElementViewController>(numberOfChildViewControllers);
		
		for (int i = 0; i < numberOfChildViewControllers; i++)
		{
			FormElement childElement = formElement().childElements().get(i);
			FormElementViewController childViewController = childElement.createViewController();
			childViewController.setParentViewController(this);
			childViewControllers.add(childViewController);
		}
		
		this.childViewControllers = childViewControllers;
	}
}

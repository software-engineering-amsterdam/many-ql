package org.nlamah.QL.ViewControllers.Form.Abstract;

import java.util.ArrayList;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;

public abstract class ParentingFormElementViewController extends FormElementViewController 
{
	private ArrayList<FormElementViewController> childViewControllers;
	
	public ParentingFormElementViewController(DeclaringFormElement modelElement) 
	{
		super(modelElement);
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void viewNeedsUpdate() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public int preferredViewHeight() 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<FormElementViewController> childViewControllers()
	{
		if (Helper.arrayExistsAndHasElements(((DeclaringFormElement) modelElement).childElements()) && !Helper.arrayExistsAndHasElements(childViewControllers))
		{
			createChildViewControllers();
		}
		
		return this.childViewControllers;
	}
	
	private void createChildViewControllers()
	{
		int numberOfChildViewControllers = ((DeclaringFormElement) modelElement).childElements().size();
		
		ArrayList<FormElementViewController> childViewControllers= new ArrayList<FormElementViewController>(numberOfChildViewControllers);
		
		for (int i = 0; i < numberOfChildViewControllers; i++)
		{
			FormElement childElement = ((DeclaringFormElement) modelElement).childElements().get(i);
			FormElementViewController childViewController = childElement.viewController();
			childViewController.parentViewController = this;
			childViewControllers.add(childViewController);
		}
		
		this.childViewControllers = childViewControllers;
	}
}

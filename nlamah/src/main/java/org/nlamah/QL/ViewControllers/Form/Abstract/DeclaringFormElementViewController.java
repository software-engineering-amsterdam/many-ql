package org.nlamah.QL.ViewControllers.Form.Abstract;

import java.util.ArrayList;

import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Views.Abstract.FormElementView;

public abstract class DeclaringFormElementViewController extends FormElementViewController 
{
	private ArrayList<FormElementViewController> childViewControllers;
	private ArrayList<FormElementView> childViews;
	
	public DeclaringFormElementViewController(DeclaringFormElement modelElement) 
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
	
	public ArrayList<FormElementViewController> childViewControllers()
	{		
		return childViewControllers;
	}
	
	public void setChildViewControllers(ArrayList<FormElementViewController> childViewControllers)
	{
		this.childViewControllers = childViewControllers;
	}

	public ArrayList<FormElementView> childViews() 
	{
		return childViews;
	}

	public void setChildViews(ArrayList<FormElementView> childViews)
	{
		this.childViews = childViews;
	}

}

package org.nlamah.QL.View.Controllers.Abstract;

import java.util.List;

import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.View.Form.Abstract.FormElementView;

public abstract class DeclaringFormElementViewController extends FormElementViewController 
{
	private List<FormElementViewController> childViewControllers;
	private List<FormElementView> childViews;
	
	public DeclaringFormElementViewController(DeclaringFormElement modelElement) 
	{
		super(modelElement);
	}
	
	public List<FormElementViewController> childViewControllers()
	{		
		return childViewControllers;
	}
	
	public void setChildViewControllers(List<FormElementViewController> childViewControllers)
	{
		this.childViewControllers = childViewControllers;
	}

	public List<FormElementView> childViews() 
	{
		return childViews;
	}

	public void setChildViews(List<FormElementView> childViews)
	{
		this.childViews = childViews;
	}

}

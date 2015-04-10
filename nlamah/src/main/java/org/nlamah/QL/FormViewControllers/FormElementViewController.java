package org.nlamah.QL.FormViewControllers;

import java.util.ArrayList;

import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.FormElementView;

public abstract class FormElementViewController implements FormElementListener
{
	private FormElement formElement;
	private FormElementView view;
	private FormElementViewController parentViewController;
	
	private ArrayList<FormElementViewController> formElementViewControllers;
	private ArrayList<FormElementView> formElementViews;
	
	public FormElementViewController(FormElement formElement)
	{
		super();
		
		this.formElement = formElement;
		
		if (formElement.formElements() != null && formElement.formElements().size() > 0)
		{
			createFormElementViewControllers();
			extractFormElementViews();
		}
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
	
	public ArrayList<FormElementView> formElementViews()
	{
		return this.formElementViews;
	}
	
	private void createFormElementViewControllers()
	{
		int numberOfFormElements = formElement.formElements().size();
		
		ArrayList<FormElementViewController> formElementViewControllers= new ArrayList<FormElementViewController>(numberOfFormElements);
		
		for (int i = 0; i < numberOfFormElements; i++)
		{
			FormElement formElement = ((Form)formElement()).formElements().get(i);
			FormElementViewController formElementViewController = formElement.createViewController();
			formElementViewController.setParentViewController(this);
			formElementViewControllers.add(formElementViewController);
		}
		
		this.formElementViewControllers = formElementViewControllers;
	}
	
	private void extractFormElementViews()
	{
		int numberOfFormElements = ((Form)formElement()).formElements().size();
		
		ArrayList<FormElementView> formElementViews = new ArrayList<FormElementView>(numberOfFormElements);
		
		for (int i = 0; i < numberOfFormElements; i++)
		{
			FormElementViewController formElementViewController = formElementViewControllers.get(i);
			FormElementView formElementView = formElementViewController.view();
			formElementViews.add(formElementView);
		}
		
		this.formElementViews = formElementViews;
	}
}

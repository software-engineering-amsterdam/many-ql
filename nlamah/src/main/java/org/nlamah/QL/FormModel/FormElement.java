package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.FormElementViewController;

public abstract class FormElement extends ASTNode
{	
	private FormElementViewController viewController;
	private ArrayList<FormElement> childElements;
	private ArrayList<FormElement> relatedElements;
	
	public FormElement()
	{
		super();
		
		relatedElements = new ArrayList<FormElement>(100);
	}
	
	public ArrayList<FormElement>childElements()
	{
		return this.childElements;
	}
	
	public void setChildElements(ArrayList<FormElement>childElements)
	{
		this.childElements = childElements;
	}
	
	public ArrayList<FormElement> relatedElements()
	{
		return this.relatedElements;
	}
	
	public void addRelatedElement(FormElement relatedElement)
	{
		relatedElements.add(relatedElement);
	}
	
	protected abstract FormElementViewController createViewController();
	
	public FormElementViewController viewController()
	{
		if (viewController == null)
		{
			viewController = createViewController();
		}
		
		return viewController;
	}
}

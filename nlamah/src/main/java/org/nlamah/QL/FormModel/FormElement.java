package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.VisibilityStrategy;

public abstract class FormElement extends ASTNode implements VisibilityStrategy
{	
	private ArrayList<FormElement> childElements;
	
	public FormElement()
	{
		super();
	}
	
	public ArrayList<FormElement>childElements()
	{
		return this.childElements;
	}
	
	public void setChildElements(ArrayList<FormElement>childElements)
	{
		this.childElements = childElements;
	}
}

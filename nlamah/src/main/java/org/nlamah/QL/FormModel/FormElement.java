package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.VisibilityStrategy;

public abstract class FormElement implements VisibilityStrategy
{	
	private ArrayList<FormElement> childElements;
	
	public ArrayList<FormElement>childElements()
	{
		return this.childElements;
	}
	
	public void setChildElements(ArrayList<FormElement>childElements)
	{
		this.childElements = childElements;
	}
	
	abstract public String toParseTreeString();
}

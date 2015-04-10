package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.VisibilityStrategy;

public abstract class FormElement implements VisibilityStrategy
{
	private String identifier;
	
	private ArrayList<FormElement> formElements;
	
	public String getIdentifier()
	{
		return this.identifier;
	}
	
	public ArrayList<FormElement>formElements()
	{
		return this.formElements;
	}
	
	abstract public String toParseTreeString();
}

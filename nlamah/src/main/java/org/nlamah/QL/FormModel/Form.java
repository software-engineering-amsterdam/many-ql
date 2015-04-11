package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.FormElementViewController;
import org.nlamah.QL.FormViewControllers.FormRootViewController;
import org.nlamah.QL.Helper.Helper;

public class Form extends FormElement
{
	private String title;
	
	public Form(String title, ArrayList<FormElement> formElements) 
	{
		this.title = title;
		
		setChildElements(formElements);
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String toParseTreeString()
	{	
		String stringToReturn = "(form form " + this.title + " {";
		
		if (Helper.arrayExistsAndHasElements(childElements()))
		{
			for (int i = 0; i < childElements().size(); i++)
			{
				stringToReturn += " ";
				
				stringToReturn += childElements().get(i).toParseTreeString();
			}
		}
		
		stringToReturn += " })";
		
		return  stringToReturn;
	}

	@Override
	protected FormElementViewController createViewController() 
	{
		return new FormRootViewController(this);
	}
}

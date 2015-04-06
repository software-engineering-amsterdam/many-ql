package org.nlamah.QL.Form;

import java.util.ArrayList;

public class Form 
{
	private String title;
	private ArrayList<FormElement> formElements;
	
	public Form(String title, ArrayList<FormElement> formElements) 
	{
		this.title = title;
		this.formElements = formElements;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public ArrayList<FormElement>getFormElements()
	{
		return this.formElements;
	}
	
	public String toParseTreeString()
	{	
		String stringToReturn = "(form form " + this.title + " {";
		
		if (formElements != null)
		{
			
			for (int i = 0; i < formElements.size(); i++)
			{
				stringToReturn += " ";
				
				stringToReturn += formElements.get(i).toParseTreeString();
			}
		}
		
		stringToReturn += " })";
		
		return  stringToReturn;
	}
}

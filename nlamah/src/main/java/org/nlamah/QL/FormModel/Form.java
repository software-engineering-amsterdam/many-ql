package org.nlamah.QL.FormModel;

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
	
	public ArrayList<FormElement> formElements()
	{
		return this.formElements;
	}
	
	public void setFormElements(ArrayList<FormElement> formElements)
	{
		this.formElements = formElements;
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

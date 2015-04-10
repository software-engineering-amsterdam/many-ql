package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.ElseThenBlockViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;

public class ElseThenBlock extends FormElement 
{	
	private ArrayList<FormElement> formElements;
	
	public ElseThenBlock(ArrayList<FormElement> formElements) 
	{
		super();
		
		this.formElements = formElements;	
	}

	@Override
	public String toParseTreeString() 
	{
		
//		String stringToReturn = "(" + this.getIdentifier() + " ";
//		stringToReturn += "else ";
//		stringToReturn += this.formElementsToParseTreeString();
//		stringToReturn += ")";
//		return stringToReturn;
		return "";
	}

	@Override
	public FormElementViewController createViewController() 
	{
		return new ElseThenBlockViewController(this);
	}
}

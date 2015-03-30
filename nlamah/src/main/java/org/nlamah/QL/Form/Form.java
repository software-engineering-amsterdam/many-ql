package org.nlamah.QL.Form;

import java.util.ArrayList;

import org.nlamah.QL.Node;

public class Form extends Node {
	
	ArrayList<FormElement> formElements;
	
	public Form(String identifier, ArrayList<FormElement> formElements) {

		super(identifier);
	
		this.formElements = formElements;
	}
	
	public String toParseTreeString()
	{	
		String stringToReturn = "(form form " + this.getIdentifier() + " {";
		
		if (formElements != null){
			
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

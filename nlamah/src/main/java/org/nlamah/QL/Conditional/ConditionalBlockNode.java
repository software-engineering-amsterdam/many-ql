package org.nlamah.QL.Conditional;

import java.util.ArrayList;

import org.nlamah.QL.Node;
import org.nlamah.QL.Expression.LogicalExpression;
import org.nlamah.QL.FormModel.FormElement;

public class ConditionalBlockNode extends Node {

	LogicalExpression logicalExpression;
	ArrayList<FormElement> formElements;
	
	public ConditionalBlockNode(String identifier, LogicalExpression logicalExpression,
			ArrayList<FormElement> formElements) {
		super(identifier);
		this.logicalExpression = logicalExpression;
		this.formElements = formElements;
	}

	@Override
	public String toParseTreeString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String formElementsToParseTreeString()
	{
		String stringToReturn = "{";
		
		if (formElements != null)
		{
			for (int i = 0; i < formElements.size(); i++)
			{
				stringToReturn += " " + formElements.get(i).toParseTreeString() + " ";
			}
		}
		else
		{
			stringToReturn += " ";
		}
		
		stringToReturn += "}";
		
		return stringToReturn;
	}
	
}

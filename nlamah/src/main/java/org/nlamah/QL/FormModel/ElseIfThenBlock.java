package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.Expression.LogicalExpression;
import org.nlamah.QL.FormViewControllers.ElseIfThenBlockViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;


public class ElseIfThenBlock extends FormElement 
{
	private LogicalExpression logicalExpression;
	private ArrayList<FormElement> formElements;
	
	public ElseIfThenBlock(LogicalExpression logicalExpression, ArrayList<FormElement> formElements) 
	{
		super();
		
		this.logicalExpression = logicalExpression;
		this.formElements = formElements;
	}
	
	@Override
	public String toParseTreeString() 
	{
		
//		String stringToReturn = "(" + this.getIdentifier() + " ";
//		stringToReturn += "elsif ( " + this.logicalExpression.toParseTreeString() + " ) ";
//		stringToReturn += this.formElementsToParseTreeString();
//		stringToReturn += ")";
		return "";
	}

	@Override
	public FormElementViewController createViewController() 
	{
		return new ElseIfThenBlockViewController(this);
	}
}

package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.ElseIfThenBlockViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;

public class ElseIfThenBlock extends FormElement 
{
	private LogicalExpressionStub logicalExpression;
	private ArrayList<FormElement> formElements;
	
	public ElseIfThenBlock(LogicalExpressionStub logicalExpression, ArrayList<FormElement> formElements) 
	{
		super();
		
		this.logicalExpression = logicalExpression;
		this.formElements = formElements;
	}
	
	public boolean isSatisfied()
	{
		return false;
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
	protected FormElementViewController createViewController() 
	{
		return new ElseIfThenBlockViewController(this);
	}
}

package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.FormElementViewController;
import org.nlamah.QL.FormViewControllers.IfThenBlockViewController;

public class IfThenBlock extends FormElement 
{
	private LogicalExpressionStub logicalExpression;
	private ArrayList<FormElement> formElements;
	
	public IfThenBlock(LogicalExpressionStub logicalExpression, ArrayList<FormElement> formElements) 
	{	
		super();
		
		this.logicalExpression = logicalExpression;
		this.formElements = formElements;
	}

	@Override
	public String toParseTreeString() 
	{			
		return "";
	}

	@Override
	public FormElementViewController createViewController() 
	{
		return new IfThenBlockViewController(this);
	}
}

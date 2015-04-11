package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.FormViewControllers.FormElementViewController;
import org.nlamah.QL.FormViewControllers.IfThenBlockViewController;

public class IfThenBlock extends FormElement 
{
	private LogicalExpressionStub logicalExpression;
	
	public IfThenBlock(LogicalExpressionStub logicalExpression, ArrayList<FormElement> childElements) 
	{	
		super();
		
		this.logicalExpression = logicalExpression;
		
		setChildElements(childElements);
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

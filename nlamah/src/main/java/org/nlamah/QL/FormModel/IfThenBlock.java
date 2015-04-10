package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.Conditional.ConditionalBlockNode;
import org.nlamah.QL.Expression.LogicalExpression;
import org.nlamah.QL.FormViewControllers.FormElementViewController;
import org.nlamah.QL.FormViewControllers.IfThenBlockViewController;

public class IfThenBlock extends FormElement 
{
	private LogicalExpression logicalExpression;
	private ArrayList<FormElement> formElements;
	
	public IfThenBlock(LogicalExpression logicalExpression, ArrayList<FormElement> formElements) 
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

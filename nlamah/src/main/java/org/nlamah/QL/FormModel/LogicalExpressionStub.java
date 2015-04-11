package org.nlamah.QL.FormModel;

import java.util.ArrayList;

public class LogicalExpressionStub extends ASTNode 
{
	public LogicalExpressionStub()
	{
		super();
	}
	
	public boolean evaluate(ArrayList<FormElement> relatedElements)
	{
		return ((BooleanQuestion) relatedElements.get(0)).isChecked();
	}
	
	@Override
	public String toParseTreeString() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}

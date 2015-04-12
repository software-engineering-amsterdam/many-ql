package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.Helper.Helper;

public class LogicalExpressionStub extends ASTNode 
{
	public LogicalExpressionStub()
	{
		super();
	}
	
	public boolean evaluate(ArrayList<FormElement> relatedElements)
	{
		if (Helper.arrayExistsAndHasElements(relatedElements))
		{
			return ((InputQuestion) relatedElements.get(0)).isChecked();
		}
		else
		{
			//TODO error feedback
		}
		
		return true;
	}
	
	@Override
	public String toParseTreeString() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}

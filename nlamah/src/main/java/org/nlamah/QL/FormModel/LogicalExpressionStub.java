package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.QLASTNode.QLASTNode;

public class LogicalExpressionStub extends QLASTNode 
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
}

package org.nlamah.QL.FormModel;

public class LogicalExpressionStub 
{
	public FormElement relatedFormElement;
	
	public boolean isSatisfied()
	{
		return ((BooleanQuestion)relatedFormElement).isChecked();
	}
}

package org.nlamah.QL.FormModel;

public abstract class FormElement 
{
	private String identifier;
	
	public String getIdentifier()
	{
		return this.identifier;
	}
	
	abstract public String toParseTreeString();
}

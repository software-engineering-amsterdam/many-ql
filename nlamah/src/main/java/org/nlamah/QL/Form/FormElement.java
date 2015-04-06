package org.nlamah.QL.Form;

public abstract class FormElement 
{
	private String identifier;
	
	public String getIdentifier()
	{
		return this.identifier;
	}
	
	abstract public String toParseTreeString();
}

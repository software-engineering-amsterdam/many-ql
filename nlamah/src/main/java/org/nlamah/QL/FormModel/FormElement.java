package org.nlamah.QL.FormModel;

import org.nlamah.QL.FormViews.VisibilityStrategy;

public abstract class FormElement implements VisibilityStrategy
{
	private String identifier;
	
	public String getIdentifier()
	{
		return this.identifier;
	}
	
	abstract public String toParseTreeString();
}

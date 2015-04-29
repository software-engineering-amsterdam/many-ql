package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class IdentifierValue extends DeclarationValue
{
	private String identifier;
	
	public IdentifierValue(String identifier)
	{
		super();
		
		this.identifier = identifier;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return identifier;
	}
}

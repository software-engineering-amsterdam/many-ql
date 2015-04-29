package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class TypeValue extends DeclarationValue 
{
	private String type;
	
	public TypeValue(String type)
	{
		this.type = type;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return type;
	}
}

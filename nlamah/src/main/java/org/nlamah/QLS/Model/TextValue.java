package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class TextValue extends DeclarationValue 
{
	private String text;
	
	public TextValue(String text)
	{
		super();
		
		this.text = text;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return text;
	}
}

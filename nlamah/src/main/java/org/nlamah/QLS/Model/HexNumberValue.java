package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class HexNumberValue extends DeclarationValue 
{
	private String hexNumber;
	
	public HexNumberValue(String hexNumber)
	{
		super();
		
		this.hexNumber = hexNumber;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return hexNumber;
	}	
}

package org.nlamah.QLS.Model;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class NumberValue extends DeclarationValue {

	private String number;
	
	public NumberValue(String number)
	{
		super();
		
		this.number = number;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return number;
	}
}

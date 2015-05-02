package org.nlamah.QLS.Model.Value;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Abstract.QLSNode;

public class NumberValue extends DeclarationValue 
{
	private int number;
	
	public NumberValue(int number)
	{
		super();
		
		this.number = number;
	}
	
	public int number()
	{
		return number;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return Integer.toString(number);
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		{
			return false;
		}
		 
		 if (!(object instanceof NumberValue))
		 {
			 return false;
		 }
		 
		 NumberValue value = (NumberValue) object;

		 
		 if (this.number != value.number)
		 {
			 return false;
		 }

		 return true;
	 }
}

package org.nlamah.QLS.Model.Value;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Abstract.QLSNode;

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

		 
		 if (!(this.number.equals(value.number)))
		 {
			 return false;
		 }

		 return true;
	 }
}

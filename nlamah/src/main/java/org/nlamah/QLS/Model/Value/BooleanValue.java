package org.nlamah.QLS.Model.Value;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Abstract.QLSNode;

public class BooleanValue extends DeclarationValue 
{
	private boolean booleanValue;
	
	public BooleanValue(boolean booleanValue)
	{
		super();
		
		this.booleanValue = booleanValue;
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return booleanValue ? "yes" : "no";
	}	
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		{
			return false;
		}
		 
		 if (!(object instanceof BooleanValue))
		 {
			 return false;
		 }
		 
		 BooleanValue value = (BooleanValue) object;

		 if (!(this.booleanValue != value.booleanValue))
		 {
			 return false;
		 }

		 return true;
	 }

}

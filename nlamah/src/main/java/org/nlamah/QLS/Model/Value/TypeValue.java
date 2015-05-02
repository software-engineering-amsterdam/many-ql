package org.nlamah.QLS.Model.Value;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Abstract.QLSNode;

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
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		{
			return false;
		}
		 
		 if (!(object instanceof TypeValue))
		 {
			 return false;
		 }
		 
		 TypeValue value = (TypeValue) object;

		 
		 if (!(this.type.equals(value.type)))
		 {
			 return false;
		 }

		 return true;
	 }
}

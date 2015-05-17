package org.nlamah.QLS.Model.Value;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;

public class IdentifierValue extends QLSNode
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
	
	@Override 
	 public boolean equals(Object object) 
	 {	
		 if (this == object)
		 {
			 return true;
		 }
		
		 if (!(object instanceof IdentifierValue))
		 {
			 return false;
		 }
		 
		 IdentifierValue value = (IdentifierValue) object;

		 
		 if (!(this.identifier.equals(value.identifier)))
		 {
			 return false;
		 }

		 return true;
	 }
}

package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.LiteralType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public abstract class Expression extends QLNode
{		
	private LiteralType type;
	
	public Expression(LiteralType type)
	{
		super();
		
		this.type = type;
	}
	
	public LiteralType type()
	{
		return type;
	}

	@Override 
	 public boolean equals(Object object) 
	 {
		if (this == object)
		 {
			 return true;
		 }
		 
		 if (!(object instanceof Expression))
		 {
			 return false;
		 }
		 
		 Expression value = (Expression) object;
		 
		 if (value.type != type)
		 {
			 return false;
		 }
		 
		 return true;
	 }
}



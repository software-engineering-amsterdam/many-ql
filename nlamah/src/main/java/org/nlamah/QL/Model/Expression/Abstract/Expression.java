package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.LiteralType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public abstract class Expression extends QLNode
{	
	private FormElement parentFormElement;
	
	private LiteralType type;
	
	public Expression(LiteralType type)
	{
		super();
		
		this.type = type;
	}
	
	public FormElement parentFormElement() 
	{
		return parentFormElement;
	}

	public void setParentFormElement(FormElement parentFormElement) 
	{
		this.parentFormElement = parentFormElement;
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



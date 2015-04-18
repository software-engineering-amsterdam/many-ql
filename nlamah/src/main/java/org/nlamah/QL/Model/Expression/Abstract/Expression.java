package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;

public abstract class Expression extends QLNode
{	
	private FormElement parentFormElement;
	
	public FormElement parentFormElement() 
	{
		return parentFormElement;
	}

	public void setParentFormElement(FormElement parentFormElement) 
	{
		this.parentFormElement = parentFormElement;
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
		 
		 return true;
	 }
	
}


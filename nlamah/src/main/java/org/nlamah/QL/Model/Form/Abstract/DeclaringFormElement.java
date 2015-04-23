package org.nlamah.QL.Model.Form.Abstract;

import java.util.ArrayList;

import org.nlamah.QL.Helper.QLHelper;

public abstract class DeclaringFormElement extends FormElement
{
	private ArrayList<FormElement> childElements;
	
	public DeclaringFormElement(ArrayList<FormElement> childElements)
	{
		super(null);
		
		this.childElements = childElements;
		
		if (QLHelper.arrayExistsAndHasElements(childElements))
		{
			for (FormElement childElement : childElements)
		    {
		    	childElement.setParentNode(this);
		    }
		}
	}
	
	public ArrayList<FormElement>childElements()
	{
		return this.childElements;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		 if (this == object)
		 {
			 return true;
		 }
		 
		 if (!(object instanceof DeclaringFormElement))
		 {
			 return false;
		 }
		 
		 DeclaringFormElement value = (DeclaringFormElement)object;
		 
		 if(childElements == null && value.childElements == null)
		 {
			 return true;
		 }
		 
		 if (!(childElements.equals(value.childElements)))
		 {
			 return false;
		 } 

		 return true;
	 }
}

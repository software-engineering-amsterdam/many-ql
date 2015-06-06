package org.nlamah.QL.Model.Form.Abstract;

import java.util.List;

import org.nlamah.QBase.Tools.ArrayTools;

public abstract class DeclaringFormElement extends FormElement
{
	private List<FormElement> childElements;

	public DeclaringFormElement(List<FormElement> childElements)
	{
		super(null);

		this.childElements = childElements;

		if (ArrayTools.arrayExistsAndHasElements(childElements))
		{
			for (FormElement childElement : childElements)
			{
				childElement.setParentNode(this);
			}
		}
	}

	public List<FormElement>childElements()
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
package org.nlamah.QL.Model.Form.Abstract;

import org.nlamah.QL.Interfaces.Controllable;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;

public abstract class FormElement extends QLNode implements Controllable
{	
	private IdentifierLiteral identifier;

	public FormElement(IdentifierLiteral identifier)
	{
		super();

		this.identifier = identifier;

		if (identifier != null)
		{
			identifier.setParentNode(this);
		}
	}

	public IdentifierLiteral identifier()
	{
		return this.identifier;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (this == object)
		{
			return true;
		}

		if (!(object instanceof FormElement))
		{
			return false;
		}

		FormElement value = (FormElement) object;

		if (this.identifier == null && value.identifier == null)
		{
			return true;
		}

		if (!(this.identifier.equals(value.identifier)))
		{
			return false;
		}

		return true;
	}
}

package org.nlamah.QL.Model.Error;

import org.nlamah.QL.Model.Error.Abstract.QLError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;

public class IdentifierTypeMismatchError extends QLError 
{
	private IdentifierLiteral identifier;

	public IdentifierTypeMismatchError(IdentifierLiteral identifier)
	{
		super();

		this.identifier = identifier;
	}

	@Override
	public String description() 
	{
		String errorString =  "ERROR: Line " + identifier.startsOnLine + ":"  + identifier.startsAtCharacterPosition;

		errorString += " There is a type mismatch regarding identifier: " + identifier.nodeString;

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof IdentifierTypeMismatchError))
		{
			return false;
		}

		IdentifierTypeMismatchError value = (IdentifierTypeMismatchError)object;

		if (!this.identifier.equals(value.identifier))
		{
			return false;
		}

		return true;
	}
}

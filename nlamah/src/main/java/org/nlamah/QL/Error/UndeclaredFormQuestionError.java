package org.nlamah.QL.Error;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;

public class UndeclaredFormQuestionError extends QBaseError 
{
	IdentifierLiteral identifier;

	public UndeclaredFormQuestionError(IdentifierLiteral identifier)
	{
		super();

		this.identifier = identifier;
	}

	@Override
	public String description() 
	{
		String errorString =  "ERROR: Line " + identifier.startsOnLine + ":"  + identifier.startsAtCharacterPosition;

		errorString += " The question with Identifier \"" + identifier.toString() + "\" isn't declared";

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof UndeclaredFormQuestionError))
		{
			return false;
		}

		UndeclaredFormQuestionError value = (UndeclaredFormQuestionError)object;

		if (!this.identifier.equals(value.identifier))
		{
			return false;
		}

		return true;
	}
}

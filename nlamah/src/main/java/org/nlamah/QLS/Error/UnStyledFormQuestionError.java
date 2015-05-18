package org.nlamah.QLS.Error;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;

public class UnStyledFormQuestionError extends QBaseError
{
	private IdentifierLiteral identifier;

	public UnStyledFormQuestionError(IdentifierLiteral identifier)
	{
		this.identifier = identifier;
	}

	@Override
	public String description() 
	{
		String errorString =  "ERROR: Line " + identifier.startsOnLine + ":"  + identifier.startsAtCharacterPosition;

		errorString += " The question with Identifier \"" + identifier.toString() + "\" isn't styled by the stylesheet";

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (this == object)
		{
			return true;
		}

		if (!(object instanceof UnStyledFormQuestionError))
		{
			return false;
		}

		UnStyledFormQuestionError value = (UnStyledFormQuestionError)object;

		if (!this.identifier.equals(value.identifier))
		{
			return false;
		}

		return true;
	}
}
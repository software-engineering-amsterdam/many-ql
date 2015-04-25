package org.nlamah.QL.Model.Error;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;

public class UndeclaredQuestionError extends QBaseError 
{
	IdentifierLiteral identifier;

	public UndeclaredQuestionError(IdentifierLiteral identifier)
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
		if (!(object instanceof UndeclaredQuestionError))
		{
			return false;
		}

		UndeclaredQuestionError value = (UndeclaredQuestionError)object;

		if (!this.identifier.equals(value.identifier))
		{
			return false;
		}

		return true;
	}
}

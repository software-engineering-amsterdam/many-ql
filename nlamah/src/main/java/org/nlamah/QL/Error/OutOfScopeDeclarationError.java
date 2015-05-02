package org.nlamah.QL.Error;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.Question;

public class OutOfScopeDeclarationError extends QBaseError 
{
	private IdentifierLiteral  identifier;
	private Question question;

	public OutOfScopeDeclarationError(IdentifierLiteral identifier, Question question)
	{
		super();

		this.identifier = identifier;
		this.question = question;
	}

	@Override
	public String description() 
	{
		String errorString =  "ERROR: Line " + identifier.startsOnLine + ":"  + identifier.startsAtCharacterPosition;

		errorString += " The question with Identifier \"" + identifier.toString() + "\" isn't declared in the right scope.<br/>";

		errorString += "<div style='margin-left:45px'>The question is declared on line: " + question.startsOnLine + ":"  + identifier.startsAtCharacterPosition + "<br/></div>";

		return errorString;	
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof OutOfScopeDeclarationError))
		{
			return false;
		}

		OutOfScopeDeclarationError value = (OutOfScopeDeclarationError)object;

		if (!this.identifier.equals(value.identifier) || !this.question.equals(value.question))
		{
			return false;
		}

		return true;
	}

}

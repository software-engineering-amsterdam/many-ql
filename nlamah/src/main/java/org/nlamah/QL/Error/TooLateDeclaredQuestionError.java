package org.nlamah.QL.Error;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;

public class TooLateDeclaredQuestionError extends QBaseError 
{
	IdentifierLiteral identifier;
	FormQuestion question;

	public TooLateDeclaredQuestionError(IdentifierLiteral identifier, FormQuestion question)
	{
		super();

		this.identifier = identifier;
		this.question = question;
	}

	@Override
	public String description() 
	{
		String errorString =  "ERROR: Line " + identifier.startsOnLine + ":"  + identifier.startsAtCharacterPosition;

		errorString = " The question with Identifier \"" + identifier.toString() + "\" should be declared before it is refered to.<br/>";

		errorString += "<div style='margin-left:45px'>The question is declared on line: " + question.startsOnLine + "<br/></div>";

		return errorString;	
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof TooLateDeclaredQuestionError))
		{
			return false;
		}

		TooLateDeclaredQuestionError value = (TooLateDeclaredQuestionError)object;

		if (!this.identifier.equals(value.identifier) || !this.question.equals(value.question))
		{
			return false;
		}

		return true;
	}

}

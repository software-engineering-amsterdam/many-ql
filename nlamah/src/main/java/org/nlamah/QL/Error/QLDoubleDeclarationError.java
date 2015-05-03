package org.nlamah.QL.Error;

import java.util.List;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;

public class QLDoubleDeclarationError extends QBaseError
{
	IdentifierLiteral identifier;
	List<FormQuestion> questions;

	public QLDoubleDeclarationError(IdentifierLiteral identifier, List<FormQuestion> declaredQuestions)
	{
		super();

		this.identifier = identifier;
		this.questions = declaredQuestions;
	}

	@Override
	public String description() 
	{			
		String errorString = "ERROR: Line " + identifier.startsOnLine + ":"  + identifier.startsAtCharacterPosition;

		errorString += ", The question with Identifier \"" + identifier.toString() + "\" is declared more than once.<br/>";

		for (FormQuestion question : questions)
		{
			errorString += "<div style='margin-left:45px'>See line: " + question.startsOnLine + "<br/></div>";
		}

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof QLDoubleDeclarationError))
		{
			return false;
		}

		QLDoubleDeclarationError value = (QLDoubleDeclarationError)object;

		if (!this.identifier.equals(value.identifier))
		{
			return false;
		}
		
		if (!this.questions.equals(value.questions))
		{
			return false;
		}

		return true;
	}
}

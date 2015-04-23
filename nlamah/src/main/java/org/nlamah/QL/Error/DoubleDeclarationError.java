package org.nlamah.QL.Error;

import java.util.ArrayList;

import org.nlamah.QL.Error.Abstract.QLError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.Question;

public class DoubleDeclarationError extends QLError
{
	IdentifierLiteral identifier;
	ArrayList<Question> questions;

	public DoubleDeclarationError(IdentifierLiteral identifier, ArrayList<Question> declaredQuestions)
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

		for (Question question : questions)
		{
			errorString += "<div style='margin-left:45px'>See line: " + question.startsOnLine + "<br/></div>";
		}

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof DoubleDeclarationError))
		{
			return false;
		}

		DoubleDeclarationError value = (DoubleDeclarationError)object;

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

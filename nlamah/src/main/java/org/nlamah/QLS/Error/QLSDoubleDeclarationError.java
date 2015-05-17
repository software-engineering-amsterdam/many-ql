package org.nlamah.QLS.Error;

import java.util.List;

import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class QLSDoubleDeclarationError extends QBaseError
{
	IdentifierValue identifier;
	List<StyledQuestion> questions;

	public QLSDoubleDeclarationError(IdentifierValue identifier, List<StyledQuestion> declaredQuestions)
	{
		super();

		this.identifier = identifier;
		this.questions = declaredQuestions;
	}

	@Override
	public String description() 
	{			
		String errorString = "ERROR: Line " + identifier.startsOnLine + ":"  + identifier.startsAtCharacterPosition;

		errorString += ", The question with Identifier \"" + identifier.toString() + "\" is placed more than once in the stylesheet.<br/>";

		for (StyledQuestion question : questions)
		{
			errorString += "<div style='margin-left:45px'>See line: " + question.startsOnLine + "<br/></div>";
		}

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof QLSDoubleDeclarationError))
		{
			return false;
		}

		QLSDoubleDeclarationError value = (QLSDoubleDeclarationError)object;

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

package org.nlamah.QL.Error;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.Question;

public class CyclicDependencyError extends QBaseError 
{
	private IdentifierLiteral identifier;
	private Question question;
	
	public CyclicDependencyError(IdentifierLiteral identifier, Question question)
	{
		super();
		
		this.identifier = identifier;
		this.question = question;
	}
	
	@Override
	public String description() 
	{
		String errorString =  "ERROR: Line " + question.startsOnLine + ":"  + question.startsAtCharacterPosition;

		errorString += " The question with identifier: " + identifier.nodeString + " has a cyclic dependency with the identifier on line:"+ identifier.startsOnLine + ":"  + identifier.startsAtCharacterPosition;

		return errorString;
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof CyclicDependencyError))
		{
			return false;
		}

		CyclicDependencyError value = (CyclicDependencyError)object;

		if (!this.identifier.equals(value.identifier) || !this.question.equals(value.question))
		{
			return false;
		}

		return true;
	}
}

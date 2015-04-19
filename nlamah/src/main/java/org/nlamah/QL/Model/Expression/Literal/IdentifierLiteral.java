package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.BooleanQuestion;
import org.nlamah.QL.Model.Form.NumberQuestion;
import org.nlamah.QL.Model.Form.TextQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.Question;

public class IdentifierLiteral extends ValueExpression 
{
	//TODO isn't this provoking unnecessary entanglement?
	private Question correspondingQuestion;
	
	public IdentifierLiteral(String identifierValueString)
	{	
		super(identifierValueString, null);
	}
	
	public void setCorrespondingQuestion(Question question)
	{
		this.correspondingQuestion = question;
	}
	
	public ValueExpression representedValue()
	{
		switch (correspondingQuestion.returnType())
		{
			case BOOLEAN: return ((BooleanQuestion)correspondingQuestion).checked();
			case NUMBER: return ((NumberQuestion) correspondingQuestion).insertedNumber();
			case TEXT: return ((TextQuestion)correspondingQuestion).insertedText();
			default: return null;
		}
	}
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}

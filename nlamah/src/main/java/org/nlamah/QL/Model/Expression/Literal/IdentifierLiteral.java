package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.Question;
import org.nlamah.QL.Visitors.QLNodeVisitor;

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

	public String value()
	{
		return valueString;
	}
	
	public ValueExpression representedValue()
	{
		return correspondingQuestion.value();
	}
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}

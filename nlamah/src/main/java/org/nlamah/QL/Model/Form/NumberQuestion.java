package org.nlamah.QL.Model.Form;

import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.InputQuestion;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class NumberQuestion extends InputQuestion 
{
	private NumberLiteral insertedNumber;
	
	public NumberQuestion(IdentifierLiteral identifier, TextLiteral questionText)
	{
		super(identifier, questionText, QuestionReturnType.NUMBER);
		
		insertedNumber = new NumberLiteral("0");
	}

	public NumberLiteral insertedNumber()
	{
		return this.insertedNumber;
	}
	
	public void setInsertedNumber(NumberLiteral insertedNumber)
	{
		this.insertedNumber = insertedNumber;
	}
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override
	public ValueExpression value() 
	{
		return insertedNumber;
	}
}

package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;

public class NumberLiteral extends ValueExpression 
{	
	private int value;
	
	public NumberLiteral(int value)
	{
		super(QBaseQuestionType.NUMBER);
		
		this.value = value;
	}
	
	public int value()
	{
		return value;
	}
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		return Integer.toString(value);
	}
}

package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class NumberLiteral extends ValueExpression 
{		
	public NumberLiteral(String numberValueString)
	{
		super(numberValueString, QuestionReturnType.NUMBER);
	}
	
	public int value()
	{
		return Integer.parseInt(valueString);
	}
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}

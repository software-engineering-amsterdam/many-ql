package org.nlamah.QL.Unary;

import org.nlamah.QL.Expression.Expression;
import org.nlamah.QL.Expression.ExpressionVisitor;
import org.nlamah.QL.Literal.ValueExpression;

public class PlusExpression extends UnaryComputationalExpression 
{
	public PlusExpression(Expression expression) 
	{
		super(expression);
	}
	
	@Override
	public ValueExpression accept(ExpressionVisitor visitor) 
	{
		return visitor.evaluate(this);	
	}
	
}

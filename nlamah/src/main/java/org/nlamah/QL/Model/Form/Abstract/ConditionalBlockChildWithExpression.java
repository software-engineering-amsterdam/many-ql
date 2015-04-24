package org.nlamah.QL.Model.Form.Abstract;

import java.util.ArrayList;

import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Evalutation.ExpressionEvaluator;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;

public abstract class ConditionalBlockChildWithExpression extends DeclaringFormElement
{
	public ConditionalBlockChildWithExpression(Expression expression, ArrayList<FormElement> childElements) 
	{
		super(childElements);
		
		this.expression = expression;
	}


	private Expression expression;
	
	
	public Expression expression()
	{
		return expression;
	}
	
	public boolean isSatisfied()
	{
		BooleanLiteral booleanLiteral = (BooleanLiteral) expression.accept(new ExpressionEvaluator());
		
		return booleanLiteral.primitiveValue();
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof ConditionalBlockChildWithExpression))
		 {
			 return false;
		 }
		 
		 ConditionalBlockChildWithExpression value = (ConditionalBlockChildWithExpression)object;
		 
		 if (!(this.expression.equals(value.expression)))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}

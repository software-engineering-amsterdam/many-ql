package org.nlamah.QL.Model.Form.Abstract;

import java.util.List;

import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Evalutation.ExpressionEvaluator;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;

public abstract class ConditionalBlockChildWithExpression extends DeclaringFormElement
{
	private Expression expression;

	public ConditionalBlockChildWithExpression(Expression expression, List<FormElement> childElements) 
	{
		super(childElements);

		this.expression = expression;
	}

	public Expression expression()
	{
		return expression;
	}

	public boolean isSatisfied()
	{
		ValueExpression booleanLiteral = (ValueExpression) expression.accept(new ExpressionEvaluator());

		return ((BooleanLiteral) booleanLiteral).primitiveValue();
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
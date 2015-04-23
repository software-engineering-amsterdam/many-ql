package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QL.Interfaces.TypeAware;
import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public abstract class ComposedExpression extends Expression implements TypeAware
{
	public ComposedExpression(LiteralType type) 
	{
		super(type);
	}
}

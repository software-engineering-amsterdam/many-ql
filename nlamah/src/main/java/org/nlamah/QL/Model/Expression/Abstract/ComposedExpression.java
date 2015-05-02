package org.nlamah.QL.Model.Expression.Abstract;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Interfaces.TypeAware;

public abstract class ComposedExpression extends Expression implements TypeAware
{
	public ComposedExpression(QBaseQuestionType type) 
	{
		super(type);
	}
}

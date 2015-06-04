package org.nlamah.QL.Interfaces;

import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;

public interface WidgetViewDelegate 
{
	public void valueChanged(ValueExpression newValue);
}
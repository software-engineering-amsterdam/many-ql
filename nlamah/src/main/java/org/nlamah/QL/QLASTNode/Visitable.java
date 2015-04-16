package org.nlamah.QL.QLASTNode;

import org.nlamah.QL.Expression.ExpressionVisitor;
import org.nlamah.QL.Literal.ValueExpression;

public interface Visitable 
{
	public ValueExpression accept(ExpressionVisitor visitor);
}

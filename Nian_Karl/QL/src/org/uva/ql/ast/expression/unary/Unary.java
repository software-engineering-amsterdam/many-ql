package org.uva.ql.ast.expression.unary;

import org.uva.ql.ast.expression.Expression;

public abstract class Unary extends Expression {

	protected final Expression expr;
	
	public Unary(Expression expr) {
		this.expr = expr;
	}
	
	public Expression getExpression() {
		return expr;
	}

}

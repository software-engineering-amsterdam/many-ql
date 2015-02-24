package org.uva.ql.ast.expression.association;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.visitor.Visitor;

public class Parenthese extends Expression{

	private final Expression expr;
	
	public Parenthese(Expression expr) {
		this.expr = expr;
	}

	public Expression getExpression() {
		return expr;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return " ( " + expr.toString() + " ) ";
	}
}

package ast.expression.association;

import ast.expression.Expression;
import ast.visitor.Visitor;

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

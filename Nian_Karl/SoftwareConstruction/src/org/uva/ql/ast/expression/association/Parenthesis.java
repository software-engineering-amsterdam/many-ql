package org.uva.ql.ast.expression.association;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class Parenthesis extends Expression {

	private final Expression expr;

	public Parenthesis(Expression expr, CodePosition pos) {
		super(pos);
		this.expr = expr;
	}

	public Expression getExpression() {
		return expr;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return " ( " + expr.toString() + " ) ";
	}

	@Override
	public Type getType(TypeChecker typeChecker) {
		return expr.getType(typeChecker);
	}

}

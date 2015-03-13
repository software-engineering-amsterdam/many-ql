package org.uva.ql.ast.expression.unary;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class Positive extends Unary {

	public Positive(Expression expr,CodePosition pos) {
		super(expr,pos);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "+" + this.expr.toString();
	}

	@Override
	public Type getType(TypeChecker typeChecker) {
		return new IntType(getPosition());
	}
	
}

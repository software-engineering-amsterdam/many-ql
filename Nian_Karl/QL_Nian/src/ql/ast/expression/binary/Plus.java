package ql.ast.expression.binary;

import ql.ast.expression.Binary;
import ql.ast.expression.Expression;
import ql.ast.visitor.Visitor;

public class Plus extends Binary {
	
	public Plus(Expression left, Expression right) {
		super(left, right);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return left.toString() + " + " + right.toString();
	}
}

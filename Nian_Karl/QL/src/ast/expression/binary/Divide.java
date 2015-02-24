package ast.expression.binary;

import ast.expression.Expression;
import ast.visitor.Visitor;

public class Divide extends Binary {

	public Divide(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.left.toString() + " / " + this.right.toString();
	}

}

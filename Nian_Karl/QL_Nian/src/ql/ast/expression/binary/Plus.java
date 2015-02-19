package ql.ast.expression.binary;

import ql.ast.expression.Binary;
import ql.ast.expression.Expression;
import ql.ast.value.Value;

public class Plus extends Binary {
	private Expression left;
	private Expression right;
	
	public Plus(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Int evaluate() {
		return (this.left.evaluate().getValue() + this.right.evaluate().getValue());
	}

}

package ql.ast.expression.binary;

import ql.ast.expression.Binary;
import ql.ast.expression.Expression;
import ql.ast.value.Int;

public class Plus extends Binary {
	
	private Expression left;
	private Expression right;
	
	public Plus(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Int evaluate() {
		Integer l = (Integer) left.evaluate().getValue();
		Integer r = (Integer) right.evaluate().getValue();
		return new Int(l + r);
	}
	
}

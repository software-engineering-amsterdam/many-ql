package org.tax.expression;

import org.tax.datatypes.QLNumber;

public class NumberOptExpr extends Expression<QLNumber<? extends Number>> {
	
	Expression<QLNumber<? extends Number>> left, right;
	String op; 
	
	public NumberOptExpr(Expression<QLNumber<? extends Number>> left, Expression<QLNumber<? extends Number>> right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public QLNumber<? extends Number> evaluate() {
		if (op.equals( "+"))
			return left.evaluate().add(right.evaluate());
		else if (op.equals( "-"))
			return left.evaluate().sub(right.evaluate());
		else if (op.equals( "*"))
			return left.evaluate().mul(right.evaluate());
		else if (op.equals( "/"))
			return left.evaluate().div(right.evaluate());
		return null;
	}

}

package org.tax.expression;

import org.tax.datatypes.QLInteger;

public class IntOpExprs extends Expression<QLInteger> {
	Expression<QLInteger> left, right;
	String op; 
	
	public IntOpExprs(Expression<QLInteger> left, Expression<QLInteger> right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public QLInteger evaluate() {
		if (op.equals( "+"))
			return new QLInteger(left.evaluate().getValue() + right.evaluate().getValue());
		else if (op.equals( "-"))
			return new QLInteger(left.evaluate().getValue() - right.evaluate().getValue());
		else if (op.equals( "*"))
			return new QLInteger(left.evaluate().getValue() * right.evaluate().getValue());
		else if (op.equals( "/"))
			return new QLInteger(left.evaluate().getValue() / right.evaluate().getValue());
		return null;
	}

}

package org.tax.expression;

import org.tax.datatypes.QLBoolean;
import org.tax.datatypes.QLNumber;



//public class BooleanCompExpr extends BooleanExpr { 
public class BooleanCompExpr extends Expression<QLBoolean> {
	Expression<QLNumber<Number>> left, right;
	String op;

	public BooleanCompExpr(Expression<QLNumber<Number>> left, Expression<QLNumber<Number>> right,
			String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public QLBoolean evaluate() {
		if (op.equals("=")) {
			return new QLBoolean(left.evaluate().compareTo(right.evaluate().getValue()) == 0);
		}
		if (op.equals("<=")) {
			return new QLBoolean(left.evaluate().compareTo(right.evaluate().getValue()) <= 0);
		}
		if (op.equals(">=")) {
			return new QLBoolean(left.evaluate().compareTo(right.evaluate().getValue()) >= 0);
		}
		if (op.equals("!=")) {
			return new QLBoolean(left.evaluate().compareTo(right.evaluate().getValue()) != 0);
		}
		if (op.equals(">")) {
			return new QLBoolean(left.evaluate().compareTo(right.evaluate().getValue()) > 0);
		}
		if (op.equals("<")) {
			return new QLBoolean(left.evaluate().compareTo(right.evaluate().getValue()) < 0);
		}
		return null;
	}

}

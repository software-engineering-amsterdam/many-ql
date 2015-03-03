package org.tax.expression;

import org.tax.datatypes.QLBoolean;

//public class BooleanBinOpExpr extends BooleanExpr { 
public class BooleanBinOpExpr extends Expression<QLBoolean> { 
	Expression<QLBoolean> left, right;
	String op;
	

	public BooleanBinOpExpr(Expression<QLBoolean> left, Expression<QLBoolean> right, String op) {
		this.left = left;
		this.right = right;
		this.op = op;
	}

	@Override
	public QLBoolean evaluate() {
		if (op.equals("&&"))
			return new QLBoolean(left.evaluate().getValue() && right.evaluate().getValue());
		else if (op.equals("||"))
			return new QLBoolean(left.evaluate().getValue() || right.evaluate().getValue());
		return null;
	}

}

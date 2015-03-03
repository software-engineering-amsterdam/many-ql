package org.tax.expression;

import org.tax.datatypes.QLBoolean;


//public class BooleanUniOpExpr extends BooleanExpr { 
public class BooleanUniOpExpr extends Expression<QLBoolean> {
	Expression<QLBoolean> operand;
	String op;


	public BooleanUniOpExpr(Expression<QLBoolean> opearnd, String op) {
		this.operand = opearnd;
		this.op = op;
	}


	@Override
	public QLBoolean evaluate() {
		return new QLBoolean(!operand.evaluate().getValue());
	}

}

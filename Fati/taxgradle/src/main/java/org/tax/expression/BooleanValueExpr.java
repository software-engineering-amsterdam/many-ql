package org.tax.expression;

import org.tax.datatypes.QLBoolean;

//public class BooleanValueExpr extends BooleanExpr {
public class BooleanValueExpr extends Expression<QLBoolean> {
	boolean value;
	
	public BooleanValueExpr(boolean value) {
		this.value = value;
	}

	@Override
	public QLBoolean evaluate() {
		return new QLBoolean(this.value);
	}
	

}

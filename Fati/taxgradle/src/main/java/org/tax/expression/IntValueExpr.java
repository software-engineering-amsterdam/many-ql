package org.tax.expression;

import org.tax.datatypes.QLInteger;

public class IntValueExpr extends Expression<QLInteger> {
	Integer value = null;
	
	public IntValueExpr(Integer value) {
		this.value = value;
	}

	@Override
	public QLInteger evaluate() {
		return  new QLInteger(value);
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

}

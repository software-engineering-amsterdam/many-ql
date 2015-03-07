package org.tax.expression;

import org.tax.datatypes.QLDecimal;

public class DecimalValueExpr extends Expression<QLDecimal> {
	Double value = null;
	
	public DecimalValueExpr(Double value) {
		this.value = value;
	}

	@Override
	public QLDecimal evaluate() {
		return  new QLDecimal(value);
	}

}

package org.tax.expression;

import org.tax.datatypes.QLMoney;

public class MoneyValueExpr extends Expression<QLMoney>{
	Double value = null;
	
	public MoneyValueExpr(double value) {
		this.value = value;
	}

	@Override
	public QLMoney evaluate() {
		return  new QLMoney(value);
	}
	

}

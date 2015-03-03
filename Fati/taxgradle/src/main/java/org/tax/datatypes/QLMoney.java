package org.tax.datatypes;

import java.text.DecimalFormat;

public class QLMoney extends QLDecimal {

	static DecimalFormat df = new DecimalFormat("#.##");

	public QLMoney(Double value) {
		super(value);
	}
	
	@Override
	public String toString() {
		return df.format(value).toString();
	}
	
	
	@Override
	public QLMoney add(QLNumber<? extends Number> that) {
		return new QLMoney(this.getValue() + (Double)(that.getValue()));
	}

	@Override
	public QLMoney sub(QLNumber<? extends Number> that) {
		return new QLMoney(this.getValue() - (Double)(that.getValue()));
	}

	@Override
	public QLMoney mul(QLNumber<? extends Number> that) {
		return new QLMoney(this.getValue() * (Double)(that.getValue()));
	}

	@Override
	public QLMoney div(QLNumber<? extends Number> that) {
		return new QLMoney(this.getValue() / (Double)(that.getValue()));
	}
	
}

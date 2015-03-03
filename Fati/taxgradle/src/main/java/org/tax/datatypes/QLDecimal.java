package org.tax.datatypes;

//public class TDecimal extends FormType {
public class QLDecimal extends QLNumber<Double> {

	public QLDecimal(Double value) {
		super(value);
	}

	@Override
	public QLDecimal add(QLNumber<? extends Number> that) {
		return new QLDecimal(this.getValue() + (Double)(that.getValue()));
	}

	@Override
	public QLDecimal sub(QLNumber<? extends Number> that) {
		return new QLDecimal(this.getValue() - (Double)(that.getValue()));
	}

	@Override
	public QLDecimal mul(QLNumber<? extends Number> that) {
		return new QLDecimal(this.getValue() * (Double)(that.getValue()));
	}

	@Override
	public QLDecimal div(QLNumber<? extends Number> that) {
		return new QLDecimal(this.getValue() / (Double)(that.getValue()));
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public int compareTo(Number o) {
		return (Double) o.doubleValue() < value.doubleValue() ? -1 :
			(Double) o.doubleValue() == value.doubleValue() ? 0 : 1;
	}
	
}

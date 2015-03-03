package org.tax.datatypes;

//public class TInteger extends FormType {
public class QLInteger extends QLNumber<Integer> {

	public QLInteger(Integer value) {
		super(value);
	}

	@Override
	public QLInteger add(QLNumber<? extends Number> that) {
		return new QLInteger(this.getValue() + (Integer)(that.getValue()));
	}

	@Override
	public QLNumber<? extends Number> sub(QLNumber<? extends Number> that) {
		return new QLInteger(this.getValue() - (Integer)(that.getValue()));
	}

	@Override
	public QLNumber<? extends Number> mul(QLNumber<? extends Number> that) {
		return new QLInteger(this.getValue() * (Integer)(that.getValue()));
	}

	@Override
	public QLNumber<? extends Number> div(QLNumber<? extends Number> that) {
		return new QLInteger(this.getValue() / (Integer)(that.getValue()));
	}

	@Override
	public String toString() {
		return Integer.valueOf(value.intValue()).toString();

	}

	@Override
	public int compareTo(Number o) {
		return (Integer) o.intValue() < value.intValue() ? -1 :
			(Integer) o.intValue() == value.intValue() ? 0 : 1;
	}
}

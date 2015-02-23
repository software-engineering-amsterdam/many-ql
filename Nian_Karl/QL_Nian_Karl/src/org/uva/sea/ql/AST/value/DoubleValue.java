package org.uva.sea.ql.AST.value;
public class DoubleValue extends AbstractValue<Double> {

	private final double doubleValue;

	public DoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}
	
	@Override
	public Double getValue() {
		return doubleValue;
	}
}
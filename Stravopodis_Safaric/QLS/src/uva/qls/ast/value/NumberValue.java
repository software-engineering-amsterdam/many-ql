package uva.qls.ast.value;

public class NumberValue extends GenericValue<Number> {
	
	private Number value;
	
	public NumberValue(Number _value){
		this.value=_value;
	}

	@Override
	public Number getValue() {
		return this.value;
	}

	@Override
	public int intValue() {
		return this.value.intValue();
	}

}

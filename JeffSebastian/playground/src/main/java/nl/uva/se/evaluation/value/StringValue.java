package nl.uva.se.evaluation.value;

public class StringValue extends Value<String> {

	public StringValue(String value) {
		super(value);
	}

	@Override
	public Value add(Value value) {
		return new StringValue(getValue() + getString(value));
	}

	@Override
	public Value equal(Value value) {
		return new BooleanValue(getString(value).equals(getValue()));
	}

	@Override
	public Value notEqual(Value value) {
		return new BooleanValue(!(getString(value).equals(getValue())));
	}
	
	private String getString(Value value) {
		StringValue strVal = (StringValue) value;
		return strVal.getValue();
	}

}

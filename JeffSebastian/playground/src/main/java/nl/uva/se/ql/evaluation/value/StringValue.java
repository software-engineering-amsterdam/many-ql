package nl.uva.se.ql.evaluation.value;

public class StringValue extends Value<String> {

	public StringValue(String value) {
		super(value);
	}

	@Override
	public Value add(Value value) {
		return value.addString(this);
	}
	
	@Override
	public Value addString(StringValue value) {
		String s = value.getValue();
		return new StringValue(s + getValue());
	}
	
	@Override
	public Value equal(Value value) {
		return value.equalString(this);
	}
	
	@Override
	public Value equalString(StringValue value) {
		String s = value.getValue();
		return new BooleanValue(s.equals(getValue()));
	}

	@Override
	public Value notEqual(Value value) {
		return value.notEqualString(this);
	}
	
	@Override
	public Value notEqualString(StringValue value) {
		String s = value.getValue();
		return new BooleanValue(!(s.equals(getValue())));
	}

}

package nl.uva.sc.encoders.qlruntime.value;

public class IntegerValue extends Value {

	private final int value;

	public IntegerValue(int value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public IntegerValue multiply(Value otherValue) {
		int result = value * ((IntegerValue) otherValue).getValue();
		return new IntegerValue(result);
	}

	@Override
	public IntegerValue divide(Value otherValue) {
		int result = value / ((IntegerValue) otherValue).getValue();
		return new IntegerValue(result);
	}

	@Override
	public IntegerValue add(Value otherValue) {
		int result = value + ((IntegerValue) otherValue).getValue();
		return new IntegerValue(result);
	}

	@Override
	public IntegerValue substract(Value otherValue) {
		int result = value - ((IntegerValue) otherValue).getValue();
		return new IntegerValue(result);
	}

	@Override
	public Value greaterThan(Value otherValue) {
		boolean result = value > ((IntegerValue) otherValue).getValue();
		return new BooleanValue(result);
	}

	@Override
	public Value lessThan(Value otherValue) {
		boolean result = value < ((IntegerValue) otherValue).getValue();
		return new BooleanValue(result);
	}

	@Override
	public BooleanValue greaterOrEqual(Value otherValue) {
		boolean result = value >= ((IntegerValue) otherValue).getValue();
		return new BooleanValue(result);
	}

	@Override
	public Value lessOrEqual(Value otherValue) {
		boolean result = value <= ((IntegerValue) otherValue).getValue();
		return new BooleanValue(result);
	}
}

package nl.uva.sc.encoders.qlruntime.model.value;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
		int result = 0;
		try {
			result = value / ((IntegerValue) otherValue).getValue();
		} catch (ArithmeticException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText(value + "/" + otherValue + " cannot be evaluated: " + e.getMessage());
			alert.show();
		}
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

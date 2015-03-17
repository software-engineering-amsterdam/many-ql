package qls.value;

import qls.Value;

public class IntegerValue extends ql.value.IntegerValue implements Value {
	public IntegerValue(int value) {
		super(value);
	}

	@Override
	public boolean assignWidth(Value argument) {
		return false;
	}

	@Override
	public boolean assignWidthInteger(IntegerValue argument) {
		return false;
	}

	@Override
	public boolean assignWidthFloat(FloatValue argument) {
		return false;
	}

	@Override
	public boolean assignHeight(Value argument) {
		return false;
	}

	@Override
	public boolean assignHeightInteger(IntegerValue argument) {
		return false;
	}

	@Override
	public boolean assignHeightFloat(FloatValue argument) {
		return false;
	}

	@Override
	public boolean assignFont(Value argument) {
		return false;
	}

	@Override
	public boolean assignFontInteger(IntegerValue argument) {
		return false;
	}

	@Override
	public boolean assignFontSize(Value argument) {
		return false;
	}

	@Override
	public boolean assignFontSizeInteger(IntegerValue argument) {
		return false;
	}

	@Override
	public boolean assignColour(Value argument) {
		return false;
	}

	@Override
	public boolean assignColourInteger(IntegerValue argument) {
		return false;
	}
}

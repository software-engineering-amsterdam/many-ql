package qls.value;

import ql.value.StringValue;
import qls.QLSValue;

public class QLSStringValue extends StringValue implements QLSValue {
	public QLSStringValue(String value) {
		super(value);
	}

	@Override
	public boolean assignWidth() {
		return false;
	}

	@Override
	public boolean assignHeight() {
		return false;
	}
}

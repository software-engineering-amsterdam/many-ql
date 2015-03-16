package qls.value;

import ql.value.StringValue;
import qls.QLSValue;

public class QLSStringValue extends StringValue implements QLSValue {
	public QLSStringValue(String value) {
		super(value);
	}

	/*
	 *  TODO: Extend these functions to look like those in the Evaluator
	 *  or TypeChecker mechanism in QL. These functions are dropped after
	 *  the getValue is passed back to the QL after QLS has run. This is
	 *  the wrapping.
	 */
	@Override
	public boolean assignWidth() {
		return false;
	}

	@Override
	public boolean assignHeight() {
		return false;
	}
}

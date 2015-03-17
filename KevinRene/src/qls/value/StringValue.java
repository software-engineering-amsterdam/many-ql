package qls.value;

import qls.Value;

public class StringValue extends ql.value.StringValue implements Value {
	public StringValue(String value) {
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

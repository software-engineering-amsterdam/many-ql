package qls.value;

import qls.Value;

public class UndefinedValue extends ql.value.UndefinedValue implements Value {
	public UndefinedValue() {
		super();
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

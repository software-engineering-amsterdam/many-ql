package org.uva.sea.ql.encoders.validation;

import org.uva.sea.ql.encoders.ast.TextLocation;

public class SyntaxError extends Validation {

	public SyntaxError(String validationMessage, TextLocation textLocation) {
		super(validationMessage, textLocation);
	}

}

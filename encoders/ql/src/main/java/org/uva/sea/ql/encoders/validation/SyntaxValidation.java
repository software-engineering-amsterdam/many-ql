package org.uva.sea.ql.encoders.validation;

import org.uva.sea.ql.encoders.ast.TextLocation;

public class SyntaxValidation extends Validation {

	public SyntaxValidation(String validationMessage, TextLocation textLocation) {
		super(validationMessage, textLocation);
	}

}

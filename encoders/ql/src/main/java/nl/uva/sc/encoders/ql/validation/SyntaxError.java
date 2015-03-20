package nl.uva.sc.encoders.ql.validation;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class SyntaxError extends Validation {

	public SyntaxError(String validationMessage, TextLocation textLocation) {
		super(validationMessage, textLocation, Type.ERROR);
	}

}

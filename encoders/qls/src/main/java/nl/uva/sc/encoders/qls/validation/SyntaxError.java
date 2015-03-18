package nl.uva.sc.encoders.qls.validation;

import nl.uva.sc.encoders.qls.ast.TextLocation;

public class SyntaxError extends Validation {

	public SyntaxError(String validationMessage, TextLocation textLocation) {
		super(validationMessage, textLocation);
	}

}

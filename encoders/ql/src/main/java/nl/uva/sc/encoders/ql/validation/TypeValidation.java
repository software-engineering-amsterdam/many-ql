package nl.uva.sc.encoders.ql.validation;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class TypeValidation extends Validation {

	public TypeValidation(String validationMessage, TextLocation textLocation, Type type) {
		super(validationMessage, textLocation, type);
	}

}

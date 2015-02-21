package org.uva.sea.ql.encoders.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

	private final List<Validation> validations = new ArrayList<Validation>();

	public void add(Validation validation) {
		validations.add(validation);
	}

	public List<Validation> getValidations() {
		return validations;
	}
}

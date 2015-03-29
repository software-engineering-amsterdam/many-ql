package nl.uva.sc.encoders.ql.validation;

import java.util.List;

public class ValidationResult {
	private List<ValidationMessage> validationMessages;

	public ValidationResult(List<ValidationMessage> validationMessages) {
		this.validationMessages = validationMessages;
	}

	public List<ValidationMessage> getValidationMessages() {
		return validationMessages;
	}

	public boolean containsErrors() {
		return validationMessages.stream().anyMatch(validation -> validation.isError());
	}
}

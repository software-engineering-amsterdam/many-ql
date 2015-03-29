package nl.uva.sc.encoders.qls.parser;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.validation.SyntaxError;
import nl.uva.sc.encoders.ql.validation.ValidationMessage;
import nl.uva.sc.encoders.ql.validation.ValidationResult;
import nl.uva.sc.encoders.qls.ast.Stylesheet;
import nl.uva.sc.encoders.qls.validation.TypeChecker;

public class StylesheetParsingResult {

	private final Stylesheet stylesheet;

	private final List<SyntaxError> syntaxErrors;

	public StylesheetParsingResult(Stylesheet stylesheet, List<SyntaxError> syntaxErrors) {
		this.stylesheet = stylesheet;
		this.syntaxErrors = syntaxErrors;
	}

	public Stylesheet getStylesheet() {
		return stylesheet;
	}

	public List<SyntaxError> getSyntaxErrors() {
		return syntaxErrors;
	}

	public ValidationResult validate(Questionnaire questionnaire) {
		List<ValidationMessage> validationMessages = new ArrayList<ValidationMessage>();
		if (!syntaxErrors.isEmpty()) {
			validationMessages.addAll(syntaxErrors);
		} else {
			TypeChecker typeChecker = new TypeChecker(stylesheet, questionnaire);
			validationMessages.addAll(typeChecker.checkTypes());
		}
		return new ValidationResult(validationMessages);
	}

}

package nl.uva.sc.encoders.ql.parser;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.validation.SyntaxError;
import nl.uva.sc.encoders.ql.validation.TypeChecker;
import nl.uva.sc.encoders.ql.validation.ValidationMessage;
import nl.uva.sc.encoders.ql.validation.ValidationResult;

public class QuestionnaireParsingResult {

	private final Questionnaire questionnaire;

	private final List<SyntaxError> syntaxErrors;

	public QuestionnaireParsingResult(Questionnaire questionnaire, List<SyntaxError> syntaxErrors) {
		this.questionnaire = questionnaire;
		this.syntaxErrors = syntaxErrors;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public List<SyntaxError> getSyntaxErrors() {
		return syntaxErrors;
	}

	public ValidationResult validate() {
		List<ValidationMessage> validationMessages = new ArrayList<ValidationMessage>();
		if (!syntaxErrors.isEmpty()) {
			validationMessages.addAll(syntaxErrors);
		} else {
			TypeChecker typeChecker = new TypeChecker(questionnaire);
			validationMessages.addAll(typeChecker.checkTypes());
		}
		return new ValidationResult(validationMessages);
	}
}

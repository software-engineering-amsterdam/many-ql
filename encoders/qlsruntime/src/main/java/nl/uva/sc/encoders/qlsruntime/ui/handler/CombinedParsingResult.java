package nl.uva.sc.encoders.qlsruntime.ui.handler;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.parser.ParsingResult;
import nl.uva.sc.encoders.ql.parser.QuestionnaireParsingResult;
import nl.uva.sc.encoders.ql.validation.ValidationMessage;
import nl.uva.sc.encoders.ql.validation.ValidationResult;
import nl.uva.sc.encoders.qls.parser.StylesheetParsingResult;

public class CombinedParsingResult implements ParsingResult {
	private final QuestionnaireParsingResult questionnaireParsingResult;
	private final StylesheetParsingResult stylesheetParsingResult;

	public CombinedParsingResult(QuestionnaireParsingResult questionnaireParsingResult,
			StylesheetParsingResult stylesheetParsingResult) {
		this.questionnaireParsingResult = questionnaireParsingResult;
		this.stylesheetParsingResult = stylesheetParsingResult;
	}

	public QuestionnaireParsingResult getQuestionnaireParsingResult() {
		return questionnaireParsingResult;
	}

	public StylesheetParsingResult getStylesheetParsingResult() {
		return stylesheetParsingResult;
	}

	public ValidationResult validate() {
		ValidationResult qlValidationResult = questionnaireParsingResult.validate();
		Questionnaire questionnaire = questionnaireParsingResult.getQuestionnaire();
		ValidationResult qlsValidationResult = stylesheetParsingResult.validate(questionnaire);
		List<ValidationMessage> validationMessages = new ArrayList<>();
		validationMessages.addAll(qlValidationResult.getValidationMessages());
		validationMessages.addAll(qlsValidationResult.getValidationMessages());
		return new ValidationResult(validationMessages);
	}
}
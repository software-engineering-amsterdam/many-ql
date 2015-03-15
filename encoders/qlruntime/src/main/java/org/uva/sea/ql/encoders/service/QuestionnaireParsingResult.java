package org.uva.sea.ql.encoders.service;

import java.util.List;

import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.validation.SyntaxError;
import org.uva.sea.ql.encoders.validation.TypeValidation;

public class QuestionnaireParsingResult {

	private final Questionnaire questionnaire;

	private final List<SyntaxError> syntaxErrors;

	private final List<TypeValidation> typeValidations;

	public QuestionnaireParsingResult(Questionnaire questionnaire, List<SyntaxError> syntaxErrors,
			List<TypeValidation> typeValidations) {
		this.questionnaire = questionnaire;
		this.syntaxErrors = syntaxErrors;
		this.typeValidations = typeValidations;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public List<SyntaxError> getSyntaxErrors() {
		return syntaxErrors;
	}

	public List<TypeValidation> getTypeValidations() {
		return typeValidations;
	}
}

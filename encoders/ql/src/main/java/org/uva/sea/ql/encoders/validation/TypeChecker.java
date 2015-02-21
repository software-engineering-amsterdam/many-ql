package org.uva.sea.ql.encoders.validation;

import java.util.List;

import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;

public class TypeChecker {

	public ValidationResult checkTypes(Questionnaire questionnaire) {
		ValidationResult validationResult = new ValidationResult();

		List<Question> questions = questionnaire.getQuestions();

		for (Question question : questions) {
			String condition = question.getCondition();
			if (condition != null) {
				Question questionRef = questionnaire.getQuestion(condition);
				if (questionRef == null) {
					Validation validation = new Validation(
							ValidationType.UNDEFINED_REFERENCE, questionRef);
					validationResult.add(validation);
				}
			}
		}
		return validationResult;
	}

}

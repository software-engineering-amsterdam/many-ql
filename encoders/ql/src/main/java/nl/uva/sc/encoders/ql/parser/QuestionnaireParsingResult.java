package nl.uva.sc.encoders.ql.parser;

import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.validation.SyntaxError;

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

}

package nl.uva.sc.encoders.qlsruntime.ui.handler;

import nl.uva.sc.encoders.ql.parser.QuestionnaireParsingResult;
import nl.uva.sc.encoders.qls.parser.StylesheetParsingResult;

public class CombinedParsingResult {
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
}
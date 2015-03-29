package nl.uva.sc.encoders.qlsruntime.ui.handler;

import java.io.IOException;
import java.net.URISyntaxException;

import nl.uva.sc.encoders.ql.parser.QuestionnaireParsingResult;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseQLButtonHandler;
import nl.uva.sc.encoders.qls.parser.StylesheetParser;
import nl.uva.sc.encoders.qls.parser.StylesheetParsingResult;

public class QLSParseButtonHandler extends ParseQLButtonHandler {

	private final InputFileTextCallback inputQLSFileTextCallback;

	public QLSParseButtonHandler(InputFileTextCallback inputQLFileTextCallback, InputFileTextCallback inputQLSFileTextCallback,
			ParseResultCallback parseResultCallback) {
		super(inputQLFileTextCallback, parseResultCallback);
		this.inputQLSFileTextCallback = inputQLSFileTextCallback;
	}

	@Override
	protected void handleInternal() throws IOException, URISyntaxException {
		QuestionnaireParsingResult questionnaireParsingResult = parseQLInputFile(getQlInputFilePath());
		StylesheetParsingResult stylesheetParsingResult = parseQLSInputFile();
		CombinedParsingResult combinedParsingResult = new CombinedParsingResult(questionnaireParsingResult, stylesheetParsingResult);
		getParseResultCallback().showResult(combinedParsingResult);
	}

	protected StylesheetParsingResult parseQLSInputFile() throws IOException, URISyntaxException {
		String inputFileText = inputQLSFileTextCallback.getInputFileText();
		String absolutePath = getAbsoluteFilePath(inputFileText);
		StylesheetParser stylesheetParser = new StylesheetParser();
		return stylesheetParser.parse(absolutePath);
	}

}

package nl.uva.sc.encoders.qlruntime.ui.handler;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import nl.uva.sc.encoders.ql.parser.QuestionnaireParser;
import nl.uva.sc.encoders.ql.parser.QuestionnaireParsingResult;

import org.controlsfx.dialog.ExceptionDialog;

public class ParseButtonHandler implements EventHandler<ActionEvent> {

	public interface ParseResultCallback {
		void showResult(QuestionnaireParsingResult parsingResult);
	}

	public interface InputFileTextCallback {
		String getInputFileText();
	}

	private final ParseResultCallback parseResultCallback;

	private final InputFileTextCallback inputFileTextCallback;

	public ParseButtonHandler(InputFileTextCallback inputFileTextCallback, ParseResultCallback parseResultCallback) {
		this.inputFileTextCallback = inputFileTextCallback;
		this.parseResultCallback = parseResultCallback;
	}

	@Override
	public void handle(ActionEvent event) {
		String inputFilePath = inputFileTextCallback.getInputFileText();
		try {
			String absolutePath = getAbsoluteFilePath(inputFilePath);
			QuestionnaireParser questionnaireParser = new QuestionnaireParser();
			QuestionnaireParsingResult questionnaireParsingResult = questionnaireParser.parse(absolutePath);
			parseResultCallback.showResult(questionnaireParsingResult);

		} catch (IOException | URISyntaxException e) {
			ExceptionDialog dialog = new ExceptionDialog(e);
			dialog.show();
			e.printStackTrace();
		}
	}

	private String getAbsoluteFilePath(String inputFilePath) throws URISyntaxException {
		URL resource = getURL(inputFilePath);
		File file;
		if (resource != null) {
			file = new File(resource.toURI());
		} else {
			file = new File(inputFilePath);
		}
		return file.getAbsolutePath();
	}

	private URL getURL(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource(path);
	}

}
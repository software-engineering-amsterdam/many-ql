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

public class ParseQLButtonHandler implements EventHandler<ActionEvent> {

	public interface ParseQLResultCallback {
		void showResult(QuestionnaireParsingResult parsingResult);
	}

	public interface InputFileTextCallback {
		String getInputFileText();
	}

	private final ParseQLResultCallback parseQLResultCallback;

	private final InputFileTextCallback inputFileTextCallback;

	public ParseQLButtonHandler(InputFileTextCallback inputFileTextCallback, ParseQLResultCallback parseQLResultCallback) {
		this.inputFileTextCallback = inputFileTextCallback;
		this.parseQLResultCallback = parseQLResultCallback;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			handleInternal();
		} catch (IOException | URISyntaxException e) {
			ExceptionDialog dialog = new ExceptionDialog(e);
			dialog.show();
			e.printStackTrace();
		}
	}

	protected void handleInternal() throws IOException, URISyntaxException {
		String inputFilePath = getQlInputFilePath();
		parseQLResultCallback.showResult(parseQLInputFile(inputFilePath));
	}

	protected String getQlInputFilePath() {
		return inputFileTextCallback.getInputFileText();
	}

	protected QuestionnaireParsingResult parseQLInputFile(String inputFilePath) throws IOException, URISyntaxException {
		String absolutePath = getAbsoluteFilePath(inputFilePath);
		QuestionnaireParser questionnaireParser = new QuestionnaireParser();
		return questionnaireParser.parse(absolutePath);
	}

	protected String getAbsoluteFilePath(String inputFilePath) throws URISyntaxException {
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
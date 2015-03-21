package nl.uva.sc.encoders.qlruntime.ui.handler;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.validation.SyntaxError;
import nl.uva.sc.encoders.ql.validation.TypeChecker;
import nl.uva.sc.encoders.ql.validation.TypeValidation;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.parser.QuestionnaireParser;
import nl.uva.sc.encoders.qlruntime.parser.QuestionnaireParsingResult;
import nl.uva.sc.encoders.qlruntime.ui.QuestionnaireGridPane;
import nl.uva.sc.encoders.qlruntime.ui.ValidationsGridPane;

import org.controlsfx.dialog.ExceptionDialog;

public class ParseButtonHandler implements EventHandler<ActionEvent> {

	private final StackPane stackPane;
	private final TextField inputFileTextField;

	public ParseButtonHandler(StackPane stackPane, TextField inputFileTextField) {
		this.stackPane = stackPane;
		this.inputFileTextField = inputFileTextField;
	}

	public StackPane getStackPane() {
		return stackPane;
	}

	@Override
	public void handle(ActionEvent event) {
		String inputFilePath = inputFileTextField.getText();
		try {
			URL resource = getURL(inputFilePath);
			File file;
			if (resource != null) {
				file = new File(resource.toURI());
			} else {
				file = new File(inputFilePath);
			}

			String absolutePath = file.getAbsolutePath();
			QuestionnaireParser questionnaireParser = new QuestionnaireParser();
			QuestionnaireParsingResult questionnaireParsingResult = questionnaireParser.parse(absolutePath);

			Node node = determineNodeToShow(questionnaireParsingResult);
			ObservableList<Node> stackPaneChildren = stackPane.getChildren();
			stackPaneChildren.clear();
			stackPaneChildren.add(node);

		} catch (IOException | URISyntaxException e) {
			ExceptionDialog dialog = new ExceptionDialog(e);
			dialog.show();
			e.printStackTrace();
		}
	}

	private URL getURL(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource(path);
	}

	private Node determineNodeToShow(QuestionnaireParsingResult questionnaireParsingResult) {
		List<SyntaxError> syntaxErrors = questionnaireParsingResult.getSyntaxErrors();
		if (!syntaxErrors.isEmpty()) {
			ValidationsGridPane validationsGridPane = new ValidationsGridPane();
			validationsGridPane.showValidations(syntaxErrors);
			return validationsGridPane;
		}

		Questionnaire questionnaire = questionnaireParsingResult.getQuestionnaire();
		TypeChecker typeChecker = new TypeChecker(questionnaire);
		List<TypeValidation> typeValidations = typeChecker.checkTypes();
		if (!typeValidations.isEmpty()) {
			ValidationsGridPane validationsGridPane = new ValidationsGridPane();
			validationsGridPane.showValidations(typeValidations);
			return validationsGridPane;
		}
		QuestionnaireToRuntimeQuestions questionnaireToRuntimeQuestions = new QuestionnaireToRuntimeQuestions();
		List<RuntimeQuestion> runtimeQuestions = questionnaireToRuntimeQuestions.createRuntimeQuestions(questionnaire);
		String questionnaireTitle = questionnaire.getName();
		QuestionnaireGridPane questionnaireGridPane = new QuestionnaireGridPane(questionnaireTitle);
		ScrollPane scrollPane = new ScrollPane(questionnaireGridPane);
		questionnaireGridPane.showQuestions(runtimeQuestions);
		scrollPane.setPrefSize(650, 500);
		return scrollPane;
	}
}
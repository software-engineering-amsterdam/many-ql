package nl.uva.sc.encoders.qlsruntime.ui;

import static nl.uva.sc.encoders.qlruntime.ui.Main.DEFAULT_QL_INPUT_FILE_DIRECTORY;
import static nl.uva.sc.encoders.qlruntime.ui.Main.DEFAULT_QL_INPUT_FILE_NAME;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.parser.QuestionnaireParsingResult;
import nl.uva.sc.encoders.ql.validation.ValidationResult;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.ui.QuestionnaireGridPane;
import nl.uva.sc.encoders.qlruntime.ui.ValidationsGridPane;
import nl.uva.sc.encoders.qlruntime.ui.handler.ChooseInputButtonHandler;
import nl.uva.sc.encoders.qlruntime.ui.handler.ChooseInputButtonHandler.PathSelectedCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseQLButtonHandler.InputFileTextCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseQLButtonHandler.ParseResultCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.QuestionnaireToRuntimeQuestions;
import nl.uva.sc.encoders.qls.ast.Page;
import nl.uva.sc.encoders.qls.ast.Stylesheet;
import nl.uva.sc.encoders.qls.parser.StylesheetParsingResult;
import nl.uva.sc.encoders.qlsruntime.ui.handler.CombinedParsingResult;
import nl.uva.sc.encoders.qlsruntime.ui.handler.QLSParseButtonHandler;

public class Main extends Application {

	private static final String DEFAULT_QLS_INPUT_FILE_DIRECTORY = "qls/";

	private static final String DEFAULT_QLS_INPUT_FILE_NAME = "stylesheet.qls";

	private static final int WIDTH = 750;

	private static final int HEIGHT = 500;

	public static void main(String[] args) {
		launch(args);
	}

	private Questionnaire questionnaire = null;

	private Stylesheet stylesheet = null;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Properties uiProperties = new UIProperties().getUIProperties();

		String propertyWindowName = uiProperties.getProperty("windowName");
		String propertyInitializationImage = uiProperties.getProperty("initializationImage");

		primaryStage.setTitle(propertyWindowName);
		primaryStage.getIcons().add(new Image(propertyInitializationImage));

		GridPane grid = new GridPane();
		grid.getStyleClass().add("grid");

		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setFillWidth(true);
		columnConstraints.setHgrow(Priority.ALWAYS);
		grid.getColumnConstraints().add(columnConstraints);

		RowConstraints rowConstraints = new RowConstraints();
		rowConstraints.setFillHeight(true);
		rowConstraints.setVgrow(Priority.ALWAYS);
		grid.getRowConstraints().add(new RowConstraints());
		grid.getRowConstraints().add(new RowConstraints());
		grid.getRowConstraints().add(rowConstraints);

		String defaultQlsLocation = DEFAULT_QLS_INPUT_FILE_DIRECTORY + DEFAULT_QLS_INPUT_FILE_NAME;
		String defaultQlLocation = DEFAULT_QL_INPUT_FILE_DIRECTORY + DEFAULT_QL_INPUT_FILE_NAME;
		final TextField qlInputFileTextField = new TextField(defaultQlLocation);
		final TextField qlsInputFileTextField = new TextField(defaultQlsLocation);
		Button qlChooseInputButton = new Button("Choose ql file...");
		Button qlsChooseInputButton = new Button("Choose qls file...");
		Button parseButton = new Button("Parse");
		Button showButton = new Button("Show");
		grid.add(qlInputFileTextField, 0, 0);
		grid.add(qlChooseInputButton, 1, 0);
		grid.add(qlsInputFileTextField, 0, 1);
		grid.add(qlsChooseInputButton, 1, 1);
		grid.add(parseButton, 2, 1);
		grid.add(showButton, 3, 1);
		showButton.setVisible(false);

		PathSelectedCallback qlPathSelectedCallback = path -> qlInputFileTextField.setText(path);
		PathSelectedCallback qlsPathSelectedCallback = path -> qlsInputFileTextField.setText(path);
		qlChooseInputButton.setOnAction(new ChooseInputButtonHandler(qlPathSelectedCallback, defaultQlLocation));
		qlsChooseInputButton.setOnAction(new ChooseInputButtonHandler(qlsPathSelectedCallback, defaultQlsLocation));

		StackPane stackPane = new StackPane();
		ValidationsGridPane validationsGridPane = new ValidationsGridPane();

		InputFileTextCallback inputQLFileTextCallback = () -> qlInputFileTextField.getText();
		InputFileTextCallback inputQLSFileTextCallback = () -> qlsInputFileTextField.getText();
		ParseResultCallback parseCombinedResultCallback = parsingResult -> {
			CombinedParsingResult combinedParsingResult = (CombinedParsingResult) parsingResult;
			QuestionnaireParsingResult questionnaireParsingResult = combinedParsingResult.getQuestionnaireParsingResult();
			showNode(stackPane, validationsGridPane);
			ValidationResult validationResult = combinedParsingResult.validate();
			showButton.setVisible(!validationResult.containsErrors());
			validationsGridPane.showValidations(validationResult.getValidationMessages());
			questionnaire = questionnaireParsingResult.getQuestionnaire();
			StylesheetParsingResult stylesheetParsingResult = combinedParsingResult.getStylesheetParsingResult();
			stylesheet = stylesheetParsingResult.getStylesheet();
		};
		parseButton.setOnAction(new QLSParseButtonHandler(inputQLFileTextCallback, inputQLSFileTextCallback,
				parseCombinedResultCallback));

		showButton.setOnAction(event -> {
			QuestionnaireToRuntimeQuestions questionnaireToRuntimeQuestions = new QuestionnaireToRuntimeQuestions();
			List<RuntimeQuestion> runtimeQuestions = questionnaireToRuntimeQuestions.createRuntimeQuestions(questionnaire);

			List<Page> pages = stylesheet.getPages();
			Pagination pagination = new Pagination(pages.size());
			pagination.setPageFactory(new Callback<Integer, Node>() {

				@Override
				public Node call(Integer pageIndex) {
					Page page = pages.get(pageIndex);
					List<RuntimeQuestion> questionsOnThisPage = runtimeQuestions.stream()
							.filter(rq -> page.containsQuestion(rq.getQuestion().getName())).collect(Collectors.toList());
					QuestionnaireGridPane questionnaireGridPane = new QuestionnaireGridPane(runtimeQuestions, questionsOnThisPage);
					return new ScrollPane(questionnaireGridPane);
				}
			});
			AnchorPane anchor = new AnchorPane();
			AnchorPane.setTopAnchor(pagination, 10.0);
			AnchorPane.setRightAnchor(pagination, 10.0);
			AnchorPane.setBottomAnchor(pagination, 10.0);
			AnchorPane.setLeftAnchor(pagination, 10.0);
			anchor.getChildren().addAll(pagination);
			showNode(stackPane, anchor);
		});

		grid.add(stackPane, 0, 2, 4, 1);

		Scene scene = new Scene(grid, WIDTH, HEIGHT);
		scene.getStylesheets().add(getClass().getResource("UIElements.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void showNode(StackPane stackPane, Node nodeToShow) {
		ObservableList<Node> stackPaneChildren = stackPane.getChildren();
		stackPaneChildren.clear();
		stackPaneChildren.add(nodeToShow);
	}
}

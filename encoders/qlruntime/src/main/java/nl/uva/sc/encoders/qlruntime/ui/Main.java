package nl.uva.sc.encoders.qlruntime.ui;

import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.parser.QuestionnaireParsingResult;
import nl.uva.sc.encoders.ql.validation.ValidationResult;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.ui.handler.ChooseInputButtonHandler;
import nl.uva.sc.encoders.qlruntime.ui.handler.ChooseInputButtonHandler.PathSelectedCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseQLButtonHandler;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseQLButtonHandler.InputFileTextCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseQLButtonHandler.ParseResultCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.QuestionnaireToRuntimeQuestions;

public class Main extends Application {

	public static final String DEFAULT_QL_INPUT_FILE_DIRECTORY = "ql/";

	public static final String DEFAULT_QL_INPUT_FILE_NAME = "input_form.ql";

	private static final int WIDTH = 750;

	private static final int HEIGHT = 600;

	public static void main(String[] args) {
		launch(args);
	}

	private Questionnaire questionnaire = null;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Questionnaire");
		primaryStage.getIcons().add(new Image("questionnaire.png"));
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

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

		String defaultLocation = DEFAULT_QL_INPUT_FILE_DIRECTORY + DEFAULT_QL_INPUT_FILE_NAME;
		final TextField inputFileTextField = new TextField(defaultLocation);
		Button chooseInputButton = new Button("Choose input file...");
		Button parseButton = new Button("Parse");
		Button showButton = new Button("Show");
		grid.add(inputFileTextField, 0, 0);
		grid.add(chooseInputButton, 1, 0);
		grid.add(parseButton, 2, 0);
		grid.add(showButton, 3, 0);
		showButton.setVisible(false);

		PathSelectedCallback pathSelectedCallback = path -> inputFileTextField.setText(path);
		chooseInputButton.setOnAction(new ChooseInputButtonHandler(pathSelectedCallback, defaultLocation));

		StackPane stackPane = new StackPane();
		ValidationsGridPane validationsGridPane = new ValidationsGridPane();

		InputFileTextCallback inputFileTextCallback = () -> inputFileTextField.getText();
		ParseResultCallback parseResultCallback = parsingResult -> {
			QuestionnaireParsingResult qlParsingResult = (QuestionnaireParsingResult) parsingResult;
			showNode(stackPane, validationsGridPane);
			ValidationResult validationResult = qlParsingResult.validate();
			showButton.setVisible(!validationResult.containsErrors());
			validationsGridPane.showValidations(validationResult.getValidationMessages());
			questionnaire = qlParsingResult.getQuestionnaire();
		};
		parseButton.setOnAction(new ParseQLButtonHandler(inputFileTextCallback, parseResultCallback));
		showButton.setOnAction(event -> {
			QuestionnaireToRuntimeQuestions questionnaireToRuntimeQuestions = new QuestionnaireToRuntimeQuestions();
			List<RuntimeQuestion> runtimeQuestions = questionnaireToRuntimeQuestions.createRuntimeQuestions(questionnaire);
			QuestionnaireGridPane questionnaireGridPane = new QuestionnaireGridPane();
			questionnaireGridPane.showQuestions(runtimeQuestions, runtimeQuestions);
			ScrollPane scrollPane = new ScrollPane(questionnaireGridPane);
			showNode(stackPane, scrollPane);
		});

		grid.add(stackPane, 0, 1, 4, 1);

		Scene scene = new Scene(grid, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void showNode(StackPane stackPane, Node nodeToShow) {
		ObservableList<Node> stackPaneChildren = stackPane.getChildren();
		stackPaneChildren.clear();
		stackPaneChildren.add(nodeToShow);
	}
}

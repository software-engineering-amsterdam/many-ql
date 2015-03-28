package nl.uva.sc.encoders.qlruntime.ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.validation.ValidationResult;
import nl.uva.sc.encoders.qlruntime.ui.handler.ChooseInputButtonHandler;
import nl.uva.sc.encoders.qlruntime.ui.handler.ChooseInputButtonHandler.PathSelectedCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseButtonHandler;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseButtonHandler.InputFileTextCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseButtonHandler.ParseResultCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.ShowButtonHandler;
import nl.uva.sc.encoders.qlruntime.ui.handler.ShowButtonHandler.QuestionnaireCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.ShowButtonHandler.ShowResultCallback;

public class Main extends Application {

	private static final int SCROLLPANE_HEIGHT = 750;

	private static final int SCROLLPANE_WIDTH = 600;

	private static final int PADDING = 100;

	public static final String DEFAULT_INPUT_FILE_DIRECTORY = "ql/";

	public static final String DEFAULT_INPUT_FILE_NAME = "input_form.ql";

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

		String defaultLocation = DEFAULT_INPUT_FILE_DIRECTORY + DEFAULT_INPUT_FILE_NAME;
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
			showNode(stackPane, validationsGridPane);
			ValidationResult validationResult = parsingResult.validate();
			showButton.setVisible(!validationResult.containsErrors());
			validationsGridPane.showValidations(validationResult.getValidationMessages());
			questionnaire = parsingResult.getQuestionnaire();
		};
		parseButton.setOnAction(new ParseButtonHandler(inputFileTextCallback, parseResultCallback));
		ShowResultCallback showResultCallback = result -> {
			ScrollPane scrollPane = new ScrollPane(result);
			scrollPane.setPrefSize(SCROLLPANE_HEIGHT, SCROLLPANE_WIDTH);
			showNode(stackPane, scrollPane);
		};
		QuestionnaireCallback questionnaireCallback = () -> questionnaire;
		showButton.setOnAction(new ShowButtonHandler(questionnaireCallback, showResultCallback));

		grid.add(stackPane, 0, 1, 4, 1);

		Scene scene = new Scene(grid, SCROLLPANE_HEIGHT + PADDING, SCROLLPANE_WIDTH + PADDING);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void showNode(StackPane stackPane, Node nodeToShow) {
		ObservableList<Node> stackPaneChildren = stackPane.getChildren();
		stackPaneChildren.clear();
		stackPaneChildren.add(nodeToShow);
	}
}

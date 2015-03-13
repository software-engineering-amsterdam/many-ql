package org.uva.sea.ql.encoders.ui;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.controlsfx.dialog.ExceptionDialog;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.runtime.AstTransformer;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestionnaire;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingService;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingServiceImpl;
import org.uva.sea.ql.encoders.validation.Validation;

public class Main extends Application {

	private static final String DEFAULT_INPUT_FILE_DIRECTORY = "ql/";

	private static final String DEFAULT_INPUT_FILE_NAME = "input_form.ql";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Questionnaire");
		primaryStage.getIcons().add(new Image("questionnaire.png"));
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		final TextField textField = new TextField(DEFAULT_INPUT_FILE_DIRECTORY
				+ DEFAULT_INPUT_FILE_NAME);
		Button chooseInputButton = new Button("Choose input file...");
		Button parseButton = new Button("Parse");
		grid.add(textField, 0, 0);
		grid.add(chooseInputButton, 1, 0);
		grid.add(parseButton, 2, 0);

		chooseInputButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					URL resource = getURL(DEFAULT_INPUT_FILE_DIRECTORY
							+ DEFAULT_INPUT_FILE_NAME);
					File file = new File(resource.toURI());
					file = file.getParentFile();
					FileChooser fileChooser = new FileChooser();
					fileChooser.setInitialDirectory(file);
					File result = fileChooser.showOpenDialog(null);
					if (result != null) {
						textField.setText(result.getPath());
					}
				} catch (URISyntaxException e) {
					ExceptionDialog dialog = new ExceptionDialog(e);
					dialog.show();
					e.printStackTrace();
				}
			}
		});
		final StackPane stackPane = new StackPane();

		parseButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					AstTransformer astTransformer = new AstTransformer();
					QuestionnaireParsingService questionnaireParsingService = new QuestionnaireParsingServiceImpl();
					String text = textField.getText();
					URL resource = getURL(text);
					File file;
					if (resource != null) {
						file = new File(resource.toURI());
					} else {
						file = new File(text);
					}

					Questionnaire questionnaire = questionnaireParsingService
							.parse(file.getAbsolutePath());
					RuntimeQuestionnaire runtimeQuestionnaire = astTransformer
							.transform(questionnaire);
					List<Validation> validations = questionnaireParsingService
							.getTypeValidations();
					stackPane.getChildren().clear();
					if (!validations.isEmpty()) {
						ValidationsUI validationsUIFactory = new ValidationsUI();
						Node validationsUI = validationsUIFactory
								.generateUI(validations);
						stackPane.getChildren().add(validationsUI);
					} else {
						QuestionnaireUI questionnaireUIFactory = new QuestionnaireUI();
						Node questionnaireUI = questionnaireUIFactory
								.generateUI(runtimeQuestionnaire);
						stackPane.getChildren().add(questionnaireUI);
					}

				} catch (IOException | URISyntaxException e) {
					ExceptionDialog dialog = new ExceptionDialog(e);
					dialog.show();
					e.printStackTrace();
				}
			}
		});

		grid.add(stackPane, 0, 1, 3, 1);

		Scene scene = new Scene(grid, 750, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private URL getURL(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource(path);
	}
}

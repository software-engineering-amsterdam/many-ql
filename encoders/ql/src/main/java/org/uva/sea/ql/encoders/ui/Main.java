package org.uva.sea.ql.encoders.ui;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.TypeValidation;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestionnaire;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingService;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingServiceImpl;

public class Main extends Application {

	private static final String DEFAULT_INPUT_FILE_LOCATION = "src/main/resources/input_form.ql";

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

		final TextField textField = new TextField(DEFAULT_INPUT_FILE_LOCATION);
		Button chooseInputButton = new Button("Choose input file...");
		Button parseButton = new Button("Parse");
		grid.add(textField, 0, 0);
		grid.add(chooseInputButton, 1, 0);
		grid.add(parseButton, 2, 0);

		chooseInputButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
				File result = fileChooser.showOpenDialog(null);
				if (result != null) {
					textField.setText(result.getPath());
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
					Questionnaire questionnaire = questionnaireParsingService.parse(textField.getText());
					RuntimeQuestionnaire runtimeQuestionnaire = astTransformer.transform(questionnaire);
					List<TypeValidation> typeValidations = questionnaireParsingService.getTypeErrors();
					if (!typeValidations.isEmpty()) {
						ValidationsUI validationsUIFactory = new ValidationsUI();
						Control validationsUI = validationsUIFactory.generateUI(typeValidations);
						stackPane.getChildren().add(validationsUI);
					} else {
						QuestionnaireUI questionnaireUIFactory = new QuestionnaireUI();
						Control questionnaireUI = questionnaireUIFactory.generateUI(runtimeQuestionnaire);
						stackPane.getChildren().add(questionnaireUI);
					}

				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});

		grid.add(stackPane, 0, 1, 3, 1);

		Scene scene = new Scene(grid, 700, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

package org.uva.sea.ql.encoders.ui;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingService;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingServiceImpl;

public class QLUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Questionnaire");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		ScrollPane scrollPane = new ScrollPane(grid);
		scrollPane.setPrefSize(550, 275);

		QuestionnaireParsingService questionnaireParsingService = new QuestionnaireParsingServiceImpl();
		try {
			Questionnaire questionnaire = questionnaireParsingService
					.parse("src/main/resources/input_form.ql");
			setUpQuestionnaireUI(questionnaire, grid);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(scrollPane, 550, 275);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void setUpQuestionnaireUI(Questionnaire questionnaire, GridPane grid) {
		Text scenetitle = new Text(questionnaire.getName());
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		List<Question> questions = questionnaire.getQuestions();
		int y = 1;
		for (Question question : questions) {
			DataType dataType = question.getDataType();
			switch (dataType) {
			case BOOLEAN:
				grid.add(new Label(question.getQuestionText()), 0, y);
				grid.add(new CheckBox("Yes"), 1, y);
				break;
			case MONEY:
				grid.add(new Label(question.getQuestionText()), 0, y);
				TextField textField = new TextField();
				grid.add(textField, 1, y);
				break;
			default:
				throw new IllegalStateException("Unsupported type: " + dataType);
			}
			y++;
		}
	}
}

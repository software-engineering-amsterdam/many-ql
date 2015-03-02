package org.uva.sea.ql.encoders.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.TypeError;
import org.uva.sea.ql.encoders.model.UIQuestion;
import org.uva.sea.ql.encoders.model.UIQuestionnaire;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingService;
import org.uva.sea.ql.encoders.service.QuestionnaireParsingServiceImpl;

public class QLUI extends Application {

	public List<TypeError> typeErrors = new ArrayList<TypeError>();

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

		AstTransformer astTransformer = new AstTransformer();
		try {
			Questionnaire questionnaire = questionnaireParsingService.parse("src/main/resources/input_form.ql");
			UIQuestionnaire uiQuestionnaire = astTransformer.transform(questionnaire);
			setUpQuestionnaireUI(uiQuestionnaire, grid);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(scrollPane, 700, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

		typeErrors = questionnaireParsingService.getTypeErrors();

		// TODO: remove hard coding of position error area
		grid.add(new Label("Type Checker errors:"), 0, 10);
		TextArea typeCheckerMessages = new TextArea();
		grid.add(typeCheckerMessages, 0, 11);
		typeCheckerMessages.setEditable(false);
		typeCheckerMessages.setStyle("-fx-text-fill: red;");

		for (TypeError typeError : typeErrors) {
			typeCheckerMessages.appendText(typeError.getName() + ": " + typeError.getTypeErrorText());
			typeCheckerMessages.appendText("\n");
		}
	}

	private void setUpQuestionnaireUI(UIQuestionnaire questionnaire, GridPane grid) {
		Text scenetitle = new Text(questionnaire.getName());
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		List<UIQuestion> questions = questionnaire.getQuestions();
		int y = 1;
		boolean initializeDisabled = false;

		for (UIQuestion uiQuestion : questions) {
			Question question = uiQuestion.getQuestion();
			DataType dataType = question.getDataType();
			grid.add(new Label(question.getQuestionText()), 0, y);
			if (question.getCondition() != null) {
				initializeDisabled = true;
			}
			switch (dataType) {
			case BOOLEAN:
				CheckBox checkBox = new CheckBox("Yes");
				checkBox.setOnAction(new CheckBoxEventHandler(uiQuestion));
				checkBox.setDisable(initializeDisabled);
				grid.add(checkBox, 1, y);
				break;
			case DATUM:
				DatePicker datePicker = new DatePicker();
				grid.add(datePicker, 1, y);
				break;
			case STRING:
			case INT:
			case DECIMAL:
			case MONEY:
				TextField textField = new TextField();
				textField.setOnKeyReleased(new TextFieldHandler(uiQuestion));
				textField.setDisable(initializeDisabled);
				grid.add(textField, 1, y);
				break;
			default:
				throw new IllegalStateException("Unsupported type: " + dataType);
			}
			y++;
		}
	}

	private class TextFieldHandler implements EventHandler<Event> {
		private UIQuestion question;

		public TextFieldHandler(UIQuestion question) {
			this.question = question;
		}

		@Override
		public void handle(Event event) {
			TextField textField = (TextField) event.getSource();
			question.setValue(textField.getText());
		}
	}

	private class CheckBoxEventHandler implements EventHandler<ActionEvent> {
		private UIQuestion question;

		public CheckBoxEventHandler(UIQuestion question) {
			this.question = question;
		}

		@Override
		public void handle(ActionEvent event) {
			CheckBox checkBox = (CheckBox) event.getSource();
			question.setValue(checkBox.isSelected());
		}
	}
}

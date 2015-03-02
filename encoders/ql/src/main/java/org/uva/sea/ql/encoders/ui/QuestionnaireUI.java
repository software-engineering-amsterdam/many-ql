package org.uva.sea.ql.encoders.ui;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestion;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestionnaire;

public class QuestionnaireUI {

	public Control generateUI(RuntimeQuestionnaire questionnaire) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		setUpQuestionnaireUI(questionnaire, grid);

		ScrollPane scrollPane = new ScrollPane(grid);
		scrollPane.setPrefSize(550, 275);
		return scrollPane;
	}

	private void setUpQuestionnaireUI(RuntimeQuestionnaire questionnaire, GridPane grid) {
		Text scenetitle = new Text(questionnaire.getName());
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		List<RuntimeQuestion> questions = questionnaire.getQuestions();
		int y = 1;
		boolean initializeDisabled = false;

		for (RuntimeQuestion runtimeQuestion : questions) {
			Question question = runtimeQuestion.getQuestion();
			DataType dataType = question.getDataType();
			grid.add(new Label(question.getQuestionText()), 0, y);
			if (question.getCondition() != null) {
				initializeDisabled = true;
			}
			switch (dataType) {
			case BOOLEAN:
				CheckBox checkBox = new CheckBox("Yes");
				checkBox.setOnAction(new CheckBoxEventHandler(runtimeQuestion));
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
				textField.setOnKeyReleased(new TextFieldHandler(runtimeQuestion));
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
		private RuntimeQuestion question;

		public TextFieldHandler(RuntimeQuestion question) {
			this.question = question;
		}

		@Override
		public void handle(Event event) {
			TextField textField = (TextField) event.getSource();
			question.setValue(textField.getText());
		}
	}

	private class CheckBoxEventHandler implements EventHandler<ActionEvent> {
		private RuntimeQuestion question;

		public CheckBoxEventHandler(RuntimeQuestion question) {
			this.question = question;
		}

		@Override
		public void handle(ActionEvent event) {
			CheckBox checkBox = (CheckBox) event.getSource();
			question.setValue(checkBox.isSelected());
		}
	}
}

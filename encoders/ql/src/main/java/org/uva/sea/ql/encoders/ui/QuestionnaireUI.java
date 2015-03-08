package org.uva.sea.ql.encoders.ui;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.runtime.ExpressionEvaluator;
import org.uva.sea.ql.encoders.runtime.RelatedQuestionVisitor;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestion;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestionnaire;
import org.uva.sea.ql.encoders.service.QuestionByName;

public class QuestionnaireUI {

	public ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

	public Control generateUI(RuntimeQuestionnaire questionnaire) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		setupQuestionnaireUI(questionnaire, grid);

		ScrollPane scrollPane = new ScrollPane(grid);
		scrollPane.setPrefSize(650, 500);
		return scrollPane;
	}

	private void setupQuestionnaireUI(RuntimeQuestionnaire questionnaire, GridPane grid) {
		Text scenetitle = new Text(questionnaire.getName());
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		List<RuntimeQuestion> runtimeQuestions = questionnaire.getQuestions();
		int y = 1;

		for (final RuntimeQuestion runtimeQuestion : runtimeQuestions) {
			Question question = runtimeQuestion.getQuestion();

			DataType dataType = question.getDataType();
			Label label = new Label(question.getQuestionText());
			grid.add(label, 0, y);
			boolean visible = question.getCondition() == null;
			label.setVisible(visible);
			final Control control;
			switch (dataType) {
			case BOOLEAN:
				control = new CheckBox("Yes");
				CheckBoxEventHandler checkBoxEventHandler = new CheckBoxEventHandler(runtimeQuestion);
				((ButtonBase) control).setOnAction(checkBoxEventHandler);
				break;
			case STRING:
			case INT:
				control = new TextField();
				control.setOnKeyReleased(new TextFieldHandler(runtimeQuestion));
				break;
			default:
				throw new IllegalStateException("Unsupported type: " + dataType);
			}
			control.setVisible(visible);

			Expression condition = question.getCondition();
			if (condition != null) {
				RelatedQuestionVisitor relatedQuestionVisitor = new RelatedQuestionVisitor();
				Set<String> relatedQuestionNames = condition.accept(relatedQuestionVisitor);
				QuestionByName questionByName = new QuestionByName();
				for (String relatedQuestionName : relatedQuestionNames) {
					RuntimeQuestion relatedQuestion = questionByName.getRuntimeQuestion(relatedQuestionName, runtimeQuestions);
					relatedQuestion.addObserver(new Observer() {

						@Override
						public void update(Observable o, Object arg) {
							boolean result = (boolean) expressionEvaluator.evaluateExpression(runtimeQuestion);
							control.setVisible(result);
							System.out.println("Waarde is nu: " + arg);
						}
					});
				}
				System.out.println(relatedQuestionNames);
			}

			Expression computed = question.getComputed();
			if (computed != null) {
				RelatedQuestionVisitor relatedQuestionVisitor = new RelatedQuestionVisitor();
				Set<String> relatedQuestionNames = computed.accept(relatedQuestionVisitor);
				QuestionByName questionByName = new QuestionByName();
				for (String relatedQuestionName : relatedQuestionNames) {
					RuntimeQuestion relatedQuestion = questionByName.getRuntimeQuestion(relatedQuestionName, runtimeQuestions);
					relatedQuestion.addObserver(new Observer() {

						@Override
						public void update(Observable o, Object arg) {
							boolean result = (boolean) expressionEvaluator.evaluateExpression(runtimeQuestion);
							System.out.println("Waarde is nu: " + arg);
						}
					});
				}
				System.out.println(relatedQuestionNames);
			}
			grid.add(control, 1, y);
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
			expressionEvaluator.evaluateExpression(question);
		}
	}
}

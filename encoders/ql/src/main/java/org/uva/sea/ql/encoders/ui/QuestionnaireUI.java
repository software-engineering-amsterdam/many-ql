package org.uva.sea.ql.encoders.ui;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.runtime.ConditionEvaluator;
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

		final List<RuntimeQuestion> runtimeQuestions = questionnaire.getQuestions();
		int y = 1;

		for (final RuntimeQuestion runtimeQuestion : runtimeQuestions) {
			Question question = runtimeQuestion.getQuestion();

			DataType<?> dataType = question.getDataType();
			final Label label = new Label(question.getQuestionText());
			grid.add(label, 0, y);
			boolean visible = question.getCondition() == null;
			label.setVisible(visible);
			ControlGenerator controlGenerator = new ControlGenerator(runtimeQuestion);
			final Control control = dataType.accept(controlGenerator);

			control.setVisible(visible);

			final Expression condition = question.getCondition();
			if (condition != null) {
				RelatedQuestionVisitor relatedQuestionVisitor = new RelatedQuestionVisitor();
				Set<String> relatedQuestionNames = condition.accept(relatedQuestionVisitor);
				QuestionByName questionByName = new QuestionByName();
				for (String relatedQuestionName : relatedQuestionNames) {
					RuntimeQuestion relatedQuestion = questionByName.getRuntimeQuestion(relatedQuestionName, runtimeQuestions);
					relatedQuestion.addObserver(new Observer() {

						@Override
						public void update(Observable o, Object arg) {
							ConditionEvaluator conditionEvaluator = new ConditionEvaluator(runtimeQuestions);
							Boolean visible = condition.accept(conditionEvaluator);
							control.setVisible(visible);
							label.setVisible(visible);
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

}

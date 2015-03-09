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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.ast.type.IntegerType;
import org.uva.sea.ql.encoders.runtime.ComputedEvaluatorVisitor;
import org.uva.sea.ql.encoders.runtime.ConditionEvaluatorVisitor;
import org.uva.sea.ql.encoders.runtime.RelatedQuestionVisitor;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestion;
import org.uva.sea.ql.encoders.runtime.RuntimeQuestionnaire;
import org.uva.sea.ql.encoders.runtime.value.BooleanValue;
import org.uva.sea.ql.encoders.runtime.value.Value;
import org.uva.sea.ql.encoders.service.OperatorTable;
import org.uva.sea.ql.encoders.service.QuestionByName;

public class QuestionnaireUI {

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

			final DataType<?> dataType = question.getDataType();
			final Label label = new Label(question.getQuestionText());
			grid.add(label, 0, y);
			boolean visible = question.getCondition() == null;
			label.setVisible(visible);
			ControlGeneratorVisitor controlGeneratorVisitor = new ControlGeneratorVisitor(runtimeQuestion);
			final Control control = dataType.accept(controlGeneratorVisitor);

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
							OperatorTable operatorTable = new OperatorTable();
							ConditionEvaluatorVisitor conditionEvaluatorVisitor = new ConditionEvaluatorVisitor(runtimeQuestions,
									operatorTable);
							BooleanValue value = condition.accept(conditionEvaluatorVisitor);
							Boolean visible = value.getValue();
							control.setVisible(visible);
							label.setVisible(visible);
							System.out.println("Waarde is nu: " + arg);
						}
					});
				}
				System.out.println(relatedQuestionNames);
			}

			final Expression computed = question.getComputed();
			if (computed != null) {
				RelatedQuestionVisitor relatedQuestionVisitor = new RelatedQuestionVisitor();
				Set<String> relatedQuestionNames = computed.accept(relatedQuestionVisitor);
				QuestionByName questionByName = new QuestionByName();
				for (String relatedQuestionName : relatedQuestionNames) {
					RuntimeQuestion relatedQuestion = questionByName.getRuntimeQuestion(relatedQuestionName, runtimeQuestions);
					relatedQuestion.addObserver(new Observer() {

						@Override
						public void update(Observable o, Object arg) {
							OperatorTable operatorTable = new OperatorTable();
							ComputedEvaluatorVisitor computedEvaluatorVisitor = new ComputedEvaluatorVisitor(runtimeQuestions,
									operatorTable);
							Value value = computed.accept(computedEvaluatorVisitor);
							runtimeQuestion.setValue(value);
							if (dataType instanceof IntegerType) {
								((TextField) control).setText(value.toString());
							}
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

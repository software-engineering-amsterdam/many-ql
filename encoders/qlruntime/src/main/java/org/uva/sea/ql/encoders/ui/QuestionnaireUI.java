package org.uva.sea.ql.encoders.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
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

import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.runtime.ExpressionEvaluator;
import org.uva.sea.ql.encoders.runtime.RelatedQuestionVisitor;
import org.uva.sea.ql.encoders.runtime.model.RuntimeQuestion;
import org.uva.sea.ql.encoders.runtime.model.RuntimeQuestionnaire;
import org.uva.sea.ql.encoders.runtime.value.BooleanValue;
import org.uva.sea.ql.encoders.runtime.value.Value;
import org.uva.sea.ql.encoders.service.OperatorTable;
import org.uva.sea.ql.encoders.service.QuestionByName;
import org.uva.sea.ql.encoders.ui.control.ControlGeneratorVisitor;
import org.uva.sea.ql.encoders.ui.control.ControlWrapper;

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

		for (RuntimeQuestion runtimeQuestion : runtimeQuestions) {
			Question question = runtimeQuestion.getQuestion();

			DataType dataType = question.getDataType();
			Label label = new Label(question.getQuestionLabel());
			grid.add(label, 0, y);
			boolean visible = question.getCondition() == null;
			label.setVisible(visible);
			ControlGeneratorVisitor controlGeneratorVisitor = new ControlGeneratorVisitor(runtimeQuestion);
			ControlWrapper controlWrapper = dataType.accept(controlGeneratorVisitor);
			Control control = controlWrapper.getControl();

			control.setVisible(visible);

			Expression condition = question.getCondition();
			if (condition != null) {
				addConditionListeners(runtimeQuestions, label, control, condition);
			}

			Expression computed = question.getComputed();
			if (computed != null) {
				control.setDisable(true);
				addComputedListeners(runtimeQuestions, runtimeQuestion, controlWrapper, computed);
			}
			grid.add(control, 1, y);
			y++;
		}
	}

	private void addConditionListeners(final List<RuntimeQuestion> runtimeQuestions, final Label label, final Control control,
			final Expression condition) {
		RelatedQuestionVisitor relatedQuestionVisitor = new RelatedQuestionVisitor();
		Set<String> relatedQuestionNames = condition.accept(relatedQuestionVisitor);
		QuestionByName questionByName = new QuestionByName();
		for (String relatedQuestionName : relatedQuestionNames) {
			RuntimeQuestion relatedQuestion = questionByName.getRuntimeQuestion(relatedQuestionName, runtimeQuestions);
			relatedQuestion.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					OperatorTable operatorTable = new OperatorTable();
					ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(runtimeQuestions, operatorTable);
					// The cast to BooleanValue should be safe, because the
					// types should already be checked at this point.
					BooleanValue value = (BooleanValue) condition.accept(expressionEvaluator);
					Boolean visible = value.getValue();
					control.setVisible(visible);
					label.setVisible(visible);
					System.out.println("Waarde is nu: " + evt.getNewValue());
				}
			});
		}
		System.out.println(relatedQuestionNames);
	}

	private void addComputedListeners(final List<RuntimeQuestion> runtimeQuestions, final RuntimeQuestion runtimeQuestion,
			final ControlWrapper controlWrapper, final Expression computed) {
		RelatedQuestionVisitor relatedQuestionVisitor = new RelatedQuestionVisitor();
		Set<String> relatedQuestionNames = computed.accept(relatedQuestionVisitor);
		QuestionByName questionByName = new QuestionByName();
		runtimeQuestion.addPropertyChangeListener(controlWrapper);
		for (String relatedQuestionName : relatedQuestionNames) {
			RuntimeQuestion relatedQuestion = questionByName.getRuntimeQuestion(relatedQuestionName, runtimeQuestions);
			relatedQuestion.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					OperatorTable operatorTable = new OperatorTable();
					ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(runtimeQuestions, operatorTable);
					Value value = computed.accept(expressionEvaluator);
					runtimeQuestion.setValue(value);
				}
			});
		}
		System.out.println(relatedQuestionNames);
	}

}

package nl.uva.sc.encoders.qlruntime.ui;

import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.qlruntime.evaluator.ExpressionEvaluator;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.model.value.BooleanValue;
import nl.uva.sc.encoders.qlruntime.model.value.Value;
import nl.uva.sc.encoders.qlruntime.ui.control.ControlGenerator;
import nl.uva.sc.encoders.qlruntime.ui.control.ControlPropertyChangeWrapper;

public class QuestionnaireGridPane extends GridPane {

	public QuestionnaireGridPane(final List<RuntimeQuestion> allRuntimeQuestions, final List<RuntimeQuestion> runtimeQuestionsToShow) {
		setAlignment(Pos.CENTER);
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(25, 25, 25, 25));

		showQuestions(allRuntimeQuestions, runtimeQuestionsToShow);
	}

	public void showQuestions(final List<RuntimeQuestion> allRuntimeQuestions, final List<RuntimeQuestion> runtimeQuestionsToShow) {
		getChildren().clear();
		int y = 1;

		for (RuntimeQuestion runtimeQuestion : runtimeQuestionsToShow) {
			Question question = runtimeQuestion.getQuestion();

			DataType dataType = question.getDataType();
			Label label = new Label(question.getQuestionLabel());
			add(label, 0, y);
			Expression condition = runtimeQuestion.getCondition();
			boolean visible = condition == null;
			label.setVisible(visible);
			ControlGenerator controlGenerator = new ControlGenerator(runtimeQuestion);
			ControlPropertyChangeWrapper controlPropertyChangeWrapper = dataType.accept(controlGenerator);
			Control control = controlPropertyChangeWrapper.getControl();

			control.setVisible(visible);

			if (condition != null) {
				addChangeListeners(runtimeQuestionsToShow, runtimeQuestion, condition, evt -> {
					ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(runtimeQuestionsToShow);
					// The cast to BooleanValue should be safe, because the
					// types should already be checked at this point.
						BooleanValue value = (BooleanValue) condition.accept(expressionEvaluator);
						Boolean visible1 = value.getValue();
						control.setVisible(visible1);
						label.setVisible(visible1);
					});
			}

			Expression computed = question.getComputed();
			if (computed != null) {
				runtimeQuestion.addPropertyChangeListener(controlPropertyChangeWrapper);
				control.setDisable(true);
				addChangeListeners(allRuntimeQuestions, runtimeQuestion, computed, evt -> {
					ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(runtimeQuestionsToShow);
					Value value = computed.accept(expressionEvaluator);
					runtimeQuestion.setValue(value);
				});
			}
			add(control, 1, y);
			y++;
		}
	}

	private void addChangeListeners(final List<RuntimeQuestion> allRuntimeQuestions, final RuntimeQuestion runtimeQuestion,
			final Expression expression, final PropertyChangeListener listener) {
		Set<String> relatedQuestionNames = new HashSet<>();
		expression.collectQuestionNames(relatedQuestionNames);
		for (String relatedQuestionName : relatedQuestionNames) {
			RuntimeQuestion relatedQuestion = RuntimeQuestion.getRuntimeQuestion(relatedQuestionName, allRuntimeQuestions);
			relatedQuestion.addPropertyChangeListener(listener);
		}
	}
}

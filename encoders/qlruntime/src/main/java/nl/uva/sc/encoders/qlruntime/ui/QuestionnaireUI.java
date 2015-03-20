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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.qlruntime.evaluator.ExpressionEvaluator;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.model.value.BooleanValue;
import nl.uva.sc.encoders.qlruntime.model.value.Value;
import nl.uva.sc.encoders.qlruntime.ui.control.ControlGenerator;
import nl.uva.sc.encoders.qlruntime.ui.control.ControlPropertyChangeWrapper;

public class QuestionnaireUI extends GridPane {

	public QuestionnaireUI(String questionnaireTitle) {
		setAlignment(Pos.CENTER);
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text(questionnaireTitle);
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		add(scenetitle, 0, 0, 2, 1);
	}

	public void showQuestions(final List<RuntimeQuestion> runtimeQuestions) {
		getChildren().clear();
		int y = 1;

		for (RuntimeQuestion runtimeQuestion : runtimeQuestions) {
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
				addChangeListeners(runtimeQuestions, runtimeQuestion, condition, evt -> {
					ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(runtimeQuestions);
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
				addChangeListeners(runtimeQuestions, runtimeQuestion, computed, evt -> {
					ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(runtimeQuestions);
					Value value = computed.accept(expressionEvaluator);
					runtimeQuestion.setValue(value);
				});
			}
			add(control, 1, y);
			y++;
		}
	}

	private void addChangeListeners(final List<RuntimeQuestion> runtimeQuestions, final RuntimeQuestion runtimeQuestion,
			final Expression expression, final PropertyChangeListener listener) {
		Set<String> relatedQuestionNames = new HashSet<>();
		expression.collectQuestionNames(relatedQuestionNames);
		for (String relatedQuestionName : relatedQuestionNames) {
			RuntimeQuestion relatedQuestion = RuntimeQuestion.getRuntimeQuestion(relatedQuestionName, runtimeQuestions);
			relatedQuestion.addPropertyChangeListener(listener);
		}
	}
}

package nl.uva.sc.encoders.qlruntime.ui;

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
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.qlruntime.evaluator.ExpressionEvaluator;
import nl.uva.sc.encoders.qlruntime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.ui.control.ControlGeneratorVisitor;
import nl.uva.sc.encoders.qlruntime.ui.control.ControlWrapper;
import nl.uva.sc.encoders.qlruntime.value.BooleanValue;
import nl.uva.sc.encoders.qlruntime.value.Value;

public class QuestionnaireUI {

	public Control generateUI(String questionnaireTitle, final List<RuntimeQuestion> runtimeQuestions) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		setupQuestionnaireUI(questionnaireTitle, runtimeQuestions, grid);

		ScrollPane scrollPane = new ScrollPane(grid);
		scrollPane.setPrefSize(650, 500);
		return scrollPane;
	}

	private void setupQuestionnaireUI(String questionnaireTitle, final List<RuntimeQuestion> runtimeQuestions, GridPane grid) {
		Text scenetitle = new Text(questionnaireTitle);
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		int y = 1;

		for (RuntimeQuestion runtimeQuestion : runtimeQuestions) {
			Question question = runtimeQuestion.getQuestion();

			DataType dataType = question.getDataType();
			Label label = new Label(question.getQuestionLabel());
			grid.add(label, 0, y);
			Expression condition = runtimeQuestion.getCondition();
			boolean visible = condition == null;
			label.setVisible(visible);
			ControlGeneratorVisitor controlGeneratorVisitor = new ControlGeneratorVisitor(runtimeQuestion);
			ControlWrapper controlWrapper = dataType.accept(controlGeneratorVisitor);
			Control control = controlWrapper.getControl();

			control.setVisible(visible);

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
		for (String relatedQuestionName : relatedQuestionNames) {
			RuntimeQuestion relatedQuestion = RuntimeQuestion.getRuntimeQuestion(relatedQuestionName, runtimeQuestions);
			relatedQuestion.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(runtimeQuestions);
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
		runtimeQuestion.addPropertyChangeListener(controlWrapper);
		for (String relatedQuestionName : relatedQuestionNames) {
			RuntimeQuestion relatedQuestion = RuntimeQuestion.getRuntimeQuestion(relatedQuestionName, runtimeQuestions);
			relatedQuestion.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(runtimeQuestions);
					Value value = computed.accept(expressionEvaluator);
					runtimeQuestion.setValue(value);
				}
			});
		}
		System.out.println(relatedQuestionNames);
	}

}

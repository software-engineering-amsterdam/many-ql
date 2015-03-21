package nl.uva.se.ql.gui.mediators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.*;
import nl.uva.se.ql.evaluation.value.*;
import nl.uva.se.ql.gui.builders.GuiBuilder;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;
import nl.uva.se.ql.gui.widgets.panes.QuestionPane;
import nl.uva.se.ql.gui.widgets.questions.calculated.BaseCalculatedQuestion;

public class GuiMediator implements Mediator {

	private ValueTable values;
	private final QuestionPane questionPane;
	private List<ConditionBox> conditions = new ArrayList<ConditionBox>();
	private Map<String, BaseCalculatedQuestion> calculations = new HashMap<String, BaseCalculatedQuestion>();

	public GuiMediator(ValueTable values, Form ast) {
		this.values = values;

		GuiBuilder guiBuilder = new GuiBuilder(this);
		guiBuilder.visit(ast);
		this.questionPane = guiBuilder.getQuestionPane();

		evaluteConditions();
		updateCalculatedQuestions();
	}

	@Override
	public void update(Question question, Value value) {
		values.addValue(question.getId(), value);
		this.values = Evaluator.evaluate(questionPane.getForm(), values);
		evaluteConditions();
		updateCalculatedQuestions();
	}

	@Override
	public void registerCondition(ConditionBox conditionBox) {
		conditions.add(conditionBox);
	}

	@SuppressWarnings("rawtypes")
	private void updateCalculatedQuestions() {
		for (Entry<String, BaseCalculatedQuestion> entry : calculations
				.entrySet()) {
			BaseCalculatedQuestion calculatedQuestion = entry.getValue();
			Value value = values.getValue(entry.getKey());

			calculatedQuestion.setValue(value);
		}
	}

	private void evaluteConditions() {
		for (ConditionBox conditionBox : conditions) {

			BooleanValue isVisible = (BooleanValue) ExpressionEvaluator
					.evaluate(conditionBox.getCondition().getExpression(),
							values);

			conditionBox.setVisible(isVisible.getValue());

		}
	}

	@Override
	public QuestionPane getQuestionPane() {
		return this.questionPane;
	}

	@Override
	public void registerCalculated(String identifier,
			BaseCalculatedQuestion baseCalculatedQuestion) {
		calculations.put(identifier, baseCalculatedQuestion);
	}
}

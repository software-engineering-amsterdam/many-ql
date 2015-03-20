package nl.uva.se.ql.gui.mediators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.Evaluator;
import nl.uva.se.ql.evaluation.ExpressionEvaluator;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.evaluation.value.BooleanValue;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.builders.GuiBuilder;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;
import nl.uva.se.ql.gui.widgets.panes.QuestionPane;
import nl.uva.se.ql.gui.widgets.questions.calculated.BaseCalculatedQuestion;

public class Mediator implements IMediator {

	private ValueTable values;
	private final QuestionPane questionPane;
	private List<ConditionBox> conditions = new ArrayList<ConditionBox>();
	private Map<String, BaseCalculatedQuestion> calculations = new HashMap<String, BaseCalculatedQuestion>();

	public Mediator(ValueTable values, Form ast) {
		this.values = values;

		GuiBuilder guiBuilder = new GuiBuilder(this);
		guiBuilder.visit(ast);
		this.questionPane = guiBuilder.getQuestionPane();

		evaluteConditions();
		updateCalculatedQuestions();
	}

	@Override
	public void Update(Question question, Value value) {
		values.addValue(question.getId(), value);
		this.values = Evaluator.evaluate(questionPane.getForm(), values);
		evaluteConditions();
		updateCalculatedQuestions();
	}

	@Override
	public void registerCondition(ConditionBox conditionBox) {
		conditions.add(conditionBox);
	}

	private void updateCalculatedQuestions() {
		for (Entry<String, BaseCalculatedQuestion> entry : calculations.entrySet()) {
			if (values.containsKey(entry.getKey())) {
				BaseCalculatedQuestion calculated = entry.getValue();
				System.out.println(values.getValue(calculated.getQuestion().getId()).getClass());
				calculated.setValue(values.getValue(calculated.getQuestion().getId()));
			}
		}		
	}

	private void evaluteConditions() {
		for (ConditionBox conditionBox : conditions) {

			BooleanValue isMatch = (BooleanValue) ExpressionEvaluator.evaluate(
					conditionBox.getCondition().getExpression(), values);

			if (isMatch.getValue()) {
				conditionBox.setVisible(true);
			} else {
				conditionBox.setVisible(false);
			}
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

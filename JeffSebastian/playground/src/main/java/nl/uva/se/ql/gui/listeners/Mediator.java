package nl.uva.se.ql.gui.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.ExpressionEvaluator;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.evaluation.value.BooleanValue;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.widgets.boxes.CalculatedBox;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;

public class Mediator implements IMediator {

	private final ValueTable values;
	private List<ConditionBox> conditions = new ArrayList<ConditionBox>();
	private Map<String, CalculatedBox> calculations = new HashMap<String, CalculatedBox>();

	public Mediator(ValueTable values) {
		this.values = values;
		evaluteConditions();
		updateCalculatedQuestions();
	}

	@Override
	public void Update(Question question, Value value) {
		values.addValue(question.getId(), value);
		evaluteConditions();
		updateCalculatedQuestions();
	}

	@Override
	public void registerCondition(ConditionBox conditionBox) {
		conditions.add(conditionBox);
	}

	@Override
	public void registerCalculated(String identifier,
			CalculatedBox calculatedBox) {
		calculations.put(identifier, calculatedBox);
	}

	private void updateCalculatedQuestions() {
		for (Entry<String, CalculatedBox> entry : calculations.entrySet()) {
			if(values.containsKey(entry.getKey())){	
				System.out.println("The valueTable"+values);
				entry.getValue().setValue(values.getValue(entry.getKey()));
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
}

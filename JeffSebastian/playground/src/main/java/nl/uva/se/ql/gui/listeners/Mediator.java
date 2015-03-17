package nl.uva.se.ql.gui.listeners;

import java.util.ArrayList;
import java.util.List;

import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.ExpressionEvaluator;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.evaluation.value.BooleanValue;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;

public class Mediator implements IMediator {

	private final ValueTable values;
	private List<ConditionBox> conditions = new ArrayList<ConditionBox>();

	public Mediator(ValueTable values) {
		this.values = values;
	}

	@Override
	public void Update(Question question, Value value) {
		values.addValue(question.getId(), value);
		evaluteConditions();
	}

	@Override
	public void registerCondition(ConditionBox conditionBox) {
		conditions.add(conditionBox);
	}

	public void evaluteConditions() {
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

	public boolean Evaluate(final Expression expression, final ValueTable values) {
		BooleanValue something = (BooleanValue) ExpressionEvaluator.evaluate(
				expression, values);
		return something.getValue();
	}
}

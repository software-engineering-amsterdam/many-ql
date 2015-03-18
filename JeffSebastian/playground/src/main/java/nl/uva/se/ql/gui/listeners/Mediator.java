package nl.uva.se.ql.gui.listeners;

import java.util.ArrayList;
import java.util.List;

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
	private List<CalculatedBox> calculations = new ArrayList<CalculatedBox>();

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
	public void registerCalculated(CalculatedBox calculatedBox) {
		calculations.add(calculatedBox);		
	}
	
	@Override
	public void registerCondition(ConditionBox conditionBox) {
		conditions.add(conditionBox);
	}
	
	private void updateCalculatedQuestions(){
		for(CalculatedBox calculatedBox : calculations){			
			if(values.containsKey(calculatedBox.getBaseQuestion().getQuestion().getId())){	
				System.out.println("this should work.");
				//calculatedBox.getBaseQuestion().setValue(values.getValue(calculatedBox.getId()));
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

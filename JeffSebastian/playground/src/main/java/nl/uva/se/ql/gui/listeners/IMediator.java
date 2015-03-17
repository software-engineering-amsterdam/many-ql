package nl.uva.se.ql.gui.listeners;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.widgets.boxes.CalculatedBox;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;

public abstract interface IMediator {
	public void Update(Question question, Value value);		
	public void registerCondition(ConditionBox conditionBox);
	public void registerCalculated(CalculatedBox calculatedBox);
}

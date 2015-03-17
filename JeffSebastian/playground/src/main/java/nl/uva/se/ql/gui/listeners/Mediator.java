package nl.uva.se.ql.gui.listeners;

import java.util.Map;

import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.ValueTable;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;
import nl.uva.se.ql.gui.widgets.questions.BaseQuestion;

public class Mediator implements IMediator {

	private final ValueTable values;
	private Map<Condition, ConditionBox> conditions;

	public Mediator(ValueTable values) {
		this.values = values;
	}

	@Override
	public void Update(Question question, Value value) {
		values.addValue(question.getId(), value);
		System.out.println(values);
	}

	@Override
	public void registerQuestion(BaseQuestion question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerCondition(ConditionBox condition) {
				
	}
}

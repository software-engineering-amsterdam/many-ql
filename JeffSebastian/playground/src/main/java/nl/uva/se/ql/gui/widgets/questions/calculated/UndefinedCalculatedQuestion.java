package nl.uva.se.ql.gui.widgets.questions.calculated;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.UndefinedValue;
import nl.uva.se.ql.gui.mediators.Mediator;

public class UndefinedCalculatedQuestion extends
		BaseCalculatedQuestion<UndefinedValue> {

	public UndefinedCalculatedQuestion(Question question, Mediator mediator) {
		super(question, mediator);
	}

	@Override
	public void setValue(UndefinedValue value) {
		this.value = value;
	}

	@Override
	public UndefinedValue getValue() {
		return value;
	}

}

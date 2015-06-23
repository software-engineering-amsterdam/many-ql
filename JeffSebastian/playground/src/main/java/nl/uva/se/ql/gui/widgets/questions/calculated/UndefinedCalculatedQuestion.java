package nl.uva.se.ql.gui.widgets.questions.calculated;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.UndefinedValue;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.validators.Validator;

public class UndefinedCalculatedQuestion extends
		BaseCalculatedQuestion<UndefinedValue> {

	public UndefinedCalculatedQuestion(Question question, Mediator mediator) {
		super(question, mediator);
	}

	@Override
	public void setValue(Value value) {
		label.setText(getQuestion().getId() + " has a undefined value.");
	}

	@Override
	public Validator<String> initValidator() {
		return null;
	}

	@Override
	public Value getValue() {
		return this.value;
	}
}

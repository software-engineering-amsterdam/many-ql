package nl.uva.se.ql.gui.widgets.questions.calculated;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.BooleanValue;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.validators.BooleanValidator;

public class BooleanCalculatedQuestion extends BaseCalculatedQuestion<Boolean> {

	public BooleanCalculatedQuestion(Question question, Mediator mediator) {
		super(question, mediator);
	}

	@Override
	public BooleanValue getValue() {
		return new BooleanValue(value);
	}

	@Override
	public void setValue(Value value) {
		if (getValidator().isValid(value)) {
			BooleanValue booleanValue = (BooleanValue) value;
			this.value = booleanValue.getValue();
			label.setText(createText(this.value.toString()));
		}
	}

	@Override
	public BooleanValidator initValidator() {
		return new BooleanValidator();
	}
}

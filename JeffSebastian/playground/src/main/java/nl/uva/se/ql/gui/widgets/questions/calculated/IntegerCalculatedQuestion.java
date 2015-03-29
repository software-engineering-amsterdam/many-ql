package nl.uva.se.ql.gui.widgets.questions.calculated;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.IntegerValue;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.validators.IntegerValidator;

public class IntegerCalculatedQuestion extends
		BaseCalculatedQuestion<Integer> {

	public IntegerCalculatedQuestion(Question question, Mediator mediator) {
		super(question, mediator);
	}

	@Override
	public IntegerValue getValue() {
		return new IntegerValue(value);
	}

	@Override
	public void setValue(Value value) {
		if (getValidator().isValid(value)) {
			IntegerValue integerValue = (IntegerValue) value;
			this.value = integerValue.getValue();
			label.setText(createText(this.value.toString()));
		}			
	}

	@Override
	public IntegerValidator initValidator() {
		return new IntegerValidator();
	}
}

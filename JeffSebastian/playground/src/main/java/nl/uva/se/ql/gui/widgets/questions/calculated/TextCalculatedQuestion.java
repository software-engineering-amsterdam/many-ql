package nl.uva.se.ql.gui.widgets.questions.calculated;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.StringValue;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.validators.TextValidator;

public class TextCalculatedQuestion extends BaseCalculatedQuestion<String> {

	public TextCalculatedQuestion(Question question, Mediator mediator) {
		super(question, mediator);
	}

	@Override
	public void setValue(Value value) {
		if (getValidator().isValid(value)) {
			StringValue stringValue = (StringValue) value;
			this.value = stringValue.getValue();
			label.setText(createText(this.value));
		}			
	}

	@Override
	public TextValidator initValidator() {
		return new TextValidator();
	}

	@Override
	public StringValue getValue() {
		return new StringValue(this.value);
	}
}

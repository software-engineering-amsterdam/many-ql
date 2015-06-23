package nl.uva.se.ql.gui.widgets.questions.calculated;

import java.math.BigDecimal;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.DecimalValue;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.validators.DecimalValidator;

public class DecimalCalculatedQuestion extends
		BaseCalculatedQuestion<BigDecimal> {

	public DecimalCalculatedQuestion(Question question, Mediator mediator) {
		super(question, mediator);

	}

	@Override
	public void setValue(Value value) {
		if (getValidator().isValid(value)) {
			DecimalValue decimalValue = (DecimalValue) value;
			this.value = decimalValue.getValue();
			label.setText(createText(this.value.toString()));
		}		
	}

	@Override
	public DecimalValidator initValidator() {
		return new DecimalValidator();
	}

	@Override
	public Value getValue() {
		// TODO Auto-generated method stub
		return null;
	}
}

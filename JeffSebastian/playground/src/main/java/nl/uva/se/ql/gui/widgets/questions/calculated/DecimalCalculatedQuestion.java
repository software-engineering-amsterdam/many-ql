package nl.uva.se.ql.gui.widgets.questions.calculated;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.DecimalValue;
import nl.uva.se.ql.gui.mediators.Mediator;

public class DecimalCalculatedQuestion extends
		BaseCalculatedQuestion<DecimalValue> {

	public DecimalCalculatedQuestion(Question question, Mediator mediator) {
		super(question, mediator);
		
	}

	@Override
	public void setValue(DecimalValue value) {
		System.out.println(value.getClass() +" "+value.getValue());
		this.value = value;
		label.setText(createText(value.getValue().toString()));
	}

	@Override
	public DecimalValue getValue() {
		return value;
	}

}

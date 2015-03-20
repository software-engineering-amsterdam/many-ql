package nl.uva.se.ql.gui.widgets.questions.calculated;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.BooleanValue;
import nl.uva.se.ql.gui.mediators.Mediator;

public class BooleanCalculatedQuestion extends BaseCalculatedQuestion<BooleanValue>{	

	public BooleanCalculatedQuestion(Question question, Mediator mediator) {
		super(question, mediator);		
	}

	@Override
	public void setValue(BooleanValue value) {
		this.value = value;
		label.setText(createText(value.getValue().toString()));
	}

	@Override
	public BooleanValue getValue() {
		return value;
	}		
	
}

package nl.uva.se.ql.gui.widgets.questions;

import javafx.scene.Node;
import javafx.scene.control.Label;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.UndefinedValue;
import nl.uva.se.ql.gui.mediators.IMediator;
import nl.uva.se.ql.gui.validators.Validator;

public class UndefinedQuestion extends BaseQuestion<UndefinedValue> {

	public UndefinedQuestion(Question question, IMediator mediator) {
		super(question, mediator);	
	}

	@Override
	public Validator<UndefinedValue> initValidator() {		
		return null;
	}

	@Override
	public UndefinedValue undoChange(UndefinedValue newValue,
			UndefinedValue oldValue) {		
		return new UndefinedValue();
	}

	@Override
	public UndefinedValue getValue() {		
		return new UndefinedValue();
	}

	@Override
	public Node getWidget() {		
		return new Label(getQuestion().getId() + " has a undefined value.");
	}

}

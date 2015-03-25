package nl.uva.se.ql.gui.widgets.questions;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.BooleanValue;
import nl.uva.se.ql.gui.listeners.Listener;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.validators.BooleanValidator;
import nl.uva.se.ql.gui.validators.Validator;

public class BooleanQuestion extends BaseQuestion<Boolean>{
	
	private CheckBox checkBox = new CheckBox();
	
	public BooleanQuestion(Question question, Mediator mediator) {
		super(question, mediator);
		Listener<Boolean> listener = new Listener<Boolean>(getMediator());
		checkBox.selectedProperty().addListener(listener.addListener(this, getValidator()));		
	}	

	@Override
	public Validator<Boolean> initValidator() {
		return new BooleanValidator();
	}

	@Override
	public Boolean undoChange(Boolean newValue, Boolean oldValue) {
		return newValue;
	}

	@Override
	public BooleanValue getValue() {
		return new BooleanValue(checkBox.selectedProperty().getValue());
	}

	@Override
	public Node getWidget() {
		return this.checkBox;
	}
	
}

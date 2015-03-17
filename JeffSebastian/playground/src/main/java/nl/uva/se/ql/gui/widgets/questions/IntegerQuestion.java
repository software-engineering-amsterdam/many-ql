package nl.uva.se.ql.gui.widgets.questions;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.IntegerValue;
import nl.uva.se.ql.gui.listeners.IMediator;
import nl.uva.se.ql.gui.listeners.Listener;
import nl.uva.se.ql.gui.validators.IntegerValidator;
import nl.uva.se.ql.gui.validators.Validator;

public class IntegerQuestion extends BaseQuestion<String> {

	private TextField textField = new TextField();

	public IntegerQuestion(Question question, IMediator mediator) {
		super(question, mediator);
		Listener<String> listener = new Listener<String>(getMediator());
		textField.textProperty().addListener(
				listener.addListener(this, getValidator()));
	}

	@Override
	public String undoChange(String newValue, String oldValue) {
		if (oldValue.equals("")) {
			oldValue = "0";
		}
		textField.setText(oldValue);
		return textField.getText();
	}

	@Override
	public Validator<String> initValidator() {
		return new IntegerValidator();
	}

	@Override
	public IntegerValue getValue() {
		return new IntegerValue(Integer.parseInt(textField.getText()));
	}

	@Override
	public Node getWidget() {
		return this.textField;
	}
}

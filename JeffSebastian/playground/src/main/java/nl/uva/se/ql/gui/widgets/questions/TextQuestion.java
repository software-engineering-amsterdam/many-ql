package nl.uva.se.ql.gui.widgets.questions;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.StringValue;
import nl.uva.se.ql.gui.listeners.Listener;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.validators.TextValidator;

public class TextQuestion extends BaseQuestion<String> {

	private TextField textField = new TextField();

	public TextQuestion(Question question, Mediator mediator) {
		super(question, mediator);
		Listener<String> listener = new Listener<String>(getMediator());
		textField.textProperty().addListener(
				listener.addListener(this, getValidator()));
	}

	@Override
	public String undoChange(String newValue, String oldValue) {
		textField.setText(oldValue);
		return textField.getText();
	}

	@Override
	public TextValidator initValidator() {
		return new TextValidator();
	}

	@Override
	public StringValue getValue() {
		return new StringValue(textField.getText());
	}

	@Override
	public Node getWidget() {
		return this.textField;
	}
}

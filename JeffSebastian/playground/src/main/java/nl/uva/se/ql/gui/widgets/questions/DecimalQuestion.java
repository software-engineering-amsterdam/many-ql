package nl.uva.se.ql.gui.widgets.questions;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.DecimalValue;
import nl.uva.se.ql.gui.listeners.IMediator;
import nl.uva.se.ql.gui.listeners.Listener;
import nl.uva.se.ql.gui.validators.DecimalValidator;
import nl.uva.se.ql.gui.validators.IntegerValidator;
import nl.uva.se.ql.gui.validators.Validator;

public class DecimalQuestion extends BaseQuestion<String> {

	private TextField textField = new TextField();
	
	public DecimalQuestion(Question question, IMediator mediator) {
		super(question, mediator);
		Listener<String> listener = new Listener<String>(getMediator());
		textField.textProperty().addListener(listener.addListener(this, getValidator()));
	}

	@Override
	public String undoChange(String newValue, String oldValue) {
		IntegerValidator integerValidator = new IntegerValidator();
		if (integerValidator.isValid(newValue)) {
			textField.setText(newValue + ".0");
			return textField.getText();
		}
		if (newValue.isEmpty() || !integerValidator.isValid(newValue)
				&& oldValue.isEmpty()) {
			textField.setText("0.0");
			return textField.getText();
		}
		textField.setText(oldValue);
		return textField.getText();
	}

	@Override
	public Validator<String> initValidator() {
		return new DecimalValidator();
	}

	@Override
	public DecimalValue getValue() {
		// Create a DecimalFormat that fits your requirements
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#0.0#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);

		// parse the string
		BigDecimal bigDecimal;
		try {
			bigDecimal = (BigDecimal) decimalFormat.parse(textField.getText());
			return new DecimalValue(bigDecimal);
		} catch (ParseException e) {
			return new DecimalValue(new BigDecimal(0.0));
		}
	}

	@Override
	public Node getWidget() {
		return this.textField;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		
	}
}

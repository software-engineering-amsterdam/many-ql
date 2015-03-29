package nl.uva.se.ql.gui.validators;

import java.math.BigDecimal;

import nl.uva.se.ql.evaluation.value.Value;


public class DecimalValidator extends Validator<String> {

	@Override
	public boolean isValid(String input) {
		if (input.matches("\\d+(\\.\\d+)")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid(Value value) {
		if(value.getValue().getClass() == BigDecimal.class){
			return true;
		}
		return false;
	}
}

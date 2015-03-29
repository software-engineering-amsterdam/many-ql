package nl.uva.se.ql.gui.validators;

import nl.uva.se.ql.evaluation.value.Value;

public class TextValidator extends Validator<String>{

	@Override
	public boolean isValid(String input) {
		if (input.matches("^[a-zA-Z ]*$")){
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid(Value value) {
		if(value.getValue().getClass() == String.class){
			return true;
		}
		return false;
	}

}

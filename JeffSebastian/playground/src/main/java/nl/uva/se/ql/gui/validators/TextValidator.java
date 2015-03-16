package nl.uva.se.ql.gui.validators;

public class TextValidator extends Validator<String>{

	@Override
	public boolean isValid(String input) {
		if (input.matches("^[a-zA-Z ]*$")){
			return true;
		}
		return false;
	}

}

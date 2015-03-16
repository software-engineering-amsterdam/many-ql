package nl.uva.se.gui.validators;

public class TextValidator extends Validator<String>{

	@Override
	public boolean isValid(String input) {
		if (input.contains("[a-zA-Z]+")){
			return true;
		}
		return false;
	}

}

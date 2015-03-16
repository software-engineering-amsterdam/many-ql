package nl.uva.se.gui.validators;


public class DecimalValidator extends Validator<String> {

	@Override
	public boolean isValid(String input) {
		if (input.matches("[0-9].[0-9]+")) {
			return true;
		}
		return false;
	}
}

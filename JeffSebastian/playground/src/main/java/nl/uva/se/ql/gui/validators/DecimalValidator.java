package nl.uva.se.ql.gui.validators;


public class DecimalValidator extends Validator<String> {

	@Override
	public boolean isValid(String input) {
		if (input.matches("\\d+(\\.\\d+)")) {
			return true;
		}
		return false;
	}
}

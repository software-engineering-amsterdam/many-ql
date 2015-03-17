package nl.uva.se.ql.gui.validators;

public class IntegerValidator extends Validator<String>{
	
	@Override
	public boolean isValid(String input) {
		if (input.matches("-?\\d+?")) {
			return true;
		}
		return false;
	}	
}

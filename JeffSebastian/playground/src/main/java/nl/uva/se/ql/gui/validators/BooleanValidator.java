package nl.uva.se.ql.gui.validators;

import nl.uva.se.ql.evaluation.value.Value;

public class BooleanValidator extends Validator<Boolean>{

	@Override
	public boolean isValid(Boolean input) {		
		return true;		
	}

	@Override
	public boolean isValid(Value value) {
		if(value.getValue().getClass() == boolean.class){
			return true;
		}
		return false;
	}
}

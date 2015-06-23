package nl.uva.se.ql.gui.validators;

import nl.uva.se.ql.evaluation.value.Value;


public abstract class Validator<T> {
	public abstract boolean isValid(T input);
	public abstract boolean isValid(Value value);
}

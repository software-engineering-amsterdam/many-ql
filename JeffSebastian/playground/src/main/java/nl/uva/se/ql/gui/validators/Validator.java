package nl.uva.se.ql.gui.validators;


public abstract class Validator<T> {
	public abstract boolean isValid(T input);
}

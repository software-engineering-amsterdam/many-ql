package nl.uva.se.gui.widgets.questions;

import nl.uva.se.gui.validators.Validator;
import nl.uva.se.ql.ast.statement.Question;

public interface BaseQuestion<T> {
	public Question getQuestion();
	public Validator<T> getValidator();
	public void undoChange(T oldValue);
	public void reset();
}

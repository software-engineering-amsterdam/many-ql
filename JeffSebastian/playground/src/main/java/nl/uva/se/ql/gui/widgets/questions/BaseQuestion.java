package nl.uva.se.ql.gui.widgets.questions;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.gui.validators.Validator;

public interface BaseQuestion<T> {
	public Question getQuestion();
	public Validator<T> getValidator();
	public void undoChange(T oldValue);
	public void reset();
}

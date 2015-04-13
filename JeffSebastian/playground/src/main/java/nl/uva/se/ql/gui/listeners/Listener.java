package nl.uva.se.ql.gui.listeners;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.validators.Validator;
import nl.uva.se.ql.gui.widgets.questions.BaseQuestion;

public class Listener<T> {

	private final Mediator med;

	public Listener(Mediator med) {
		this.med = med;
	}

	public ChangeListener<T> addListener(final BaseQuestion<T> question, final Validator validator) {
		return new ChangeListener<T>() {

			@Override
			public void changed(ObservableValue<? extends T> observable,
					T oldValue, T newValue) {
				if (validator.isValid(newValue)) {
					med.update(question.getQuestion(), question.getValue());
				} else {
					question.undoChange(newValue, oldValue);
				}
			}
		};
	}
}

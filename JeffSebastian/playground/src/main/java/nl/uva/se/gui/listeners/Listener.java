package nl.uva.se.gui.listeners;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import nl.uva.se.gui.validators.Validator;
import nl.uva.se.gui.widgets.questions.BaseQuestion;

public class Listener<T> {
	
	public ChangeListener<T> addListener(BaseQuestion<T> question, Validator<T> validator) {
		return new ChangeListener<T>() {

			@Override
			public void changed(ObservableValue<? extends T> observable,
					T oldValue, T newValue) {
				if(validator.isValid(newValue)){
					System.out.println("this is accepted input ");
				}else{
					System.out.println("this should undo changes");
					//question.undoChange(oldValue);
				}
			}
		};
	}
}

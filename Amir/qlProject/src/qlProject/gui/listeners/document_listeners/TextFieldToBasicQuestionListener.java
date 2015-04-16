package qlProject.gui.listeners.document_listeners;

import qlProject.gui.InputInterpreter;

public class TextFieldToBasicQuestionListener extends DocumentInputListener {

	public TextFieldToBasicQuestionListener(String observed, InputInterpreter interpreter) {
		super(observed, interpreter);
	}

	@Override
	public void notifyChange(){
			interpreter.updateInputValue(observed);
	}
}
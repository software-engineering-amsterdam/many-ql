package qlProject.gui.listeners.document_listeners;

import qlProject.ast.statement.IfStatement;
import qlProject.gui.InputInterpreter;

public class TextFieldToConditionalQuestionsListListener extends DocumentInputListener {

	private IfStatement ifStatement;

	public TextFieldToConditionalQuestionsListListener(String observed, 
			IfStatement ifStatement, InputInterpreter interpreter) {
		super(observed, interpreter);
		this.ifStatement = ifStatement;
	}

	@Override
	public void notifyChange(){
		interpreter.updateInputValue(observed);
		interpreter.applyVisibilityCondition(ifStatement);
	}
}
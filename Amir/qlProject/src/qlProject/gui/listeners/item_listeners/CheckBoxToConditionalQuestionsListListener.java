package qlProject.gui.listeners.item_listeners;

import java.awt.event.ItemEvent;

import qlProject.ast.statement.IfStatement;
import qlProject.gui.InputInterpreter;

public class CheckBoxToConditionalQuestionsListListener extends InputItemListener {

	private final IfStatement ifStatement;

	public CheckBoxToConditionalQuestionsListListener(String observed, 
			IfStatement ifStatement, InputInterpreter interpreter) {
		super(observed, interpreter);
		this.ifStatement = ifStatement;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		interpreter.updateInputValue(observed);
		interpreter.applyVisibilityCondition(ifStatement);
	}
}
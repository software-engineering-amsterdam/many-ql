package qlProject.gui.listeners.item_listeners;

import java.awt.event.ItemEvent;

import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.gui.InputInterpreter;

public class CheckBoxToComputedListener extends InputItemListener {

	private final ComputedAssignment assignment;

	public CheckBoxToComputedListener(String observed, ComputedAssignment assignment, InputInterpreter interpreter) {
		super(observed, interpreter);
		this.assignment = assignment;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		interpreter.updateInputValue(observed);
		interpreter.updateComputedValues(assignment);
	}
}
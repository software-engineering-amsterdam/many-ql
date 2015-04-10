package qlProject.gui.listeners.document_listeners;

import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.gui.InputInterpreter;

public class TextFieldToComputedListener extends DocumentInputListener {
	private ComputedAssignment assignment;
	
	public TextFieldToComputedListener(String observed, ComputedAssignment assignment, InputInterpreter interpreter){
		super(observed, interpreter);
		this.assignment = assignment;
	}

	public void notifyChange(){
		interpreter.updateInputValue(observed);
		interpreter.updateComputedValues(assignment);
	}
}

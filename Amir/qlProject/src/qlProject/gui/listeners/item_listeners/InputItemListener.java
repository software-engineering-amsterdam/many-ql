package qlProject.gui.listeners.item_listeners;

import java.awt.event.ItemListener;

import qlProject.gui.InputInterpreter;

public abstract class InputItemListener implements ItemListener {

	protected final String observed;
	protected final InputInterpreter interpreter;

	public InputItemListener(String observed, InputInterpreter interpreter){	
		this.interpreter = interpreter;
		this.observed = observed;
	}
}
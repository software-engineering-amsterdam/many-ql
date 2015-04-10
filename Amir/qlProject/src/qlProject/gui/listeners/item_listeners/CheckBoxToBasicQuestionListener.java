package qlProject.gui.listeners.item_listeners;

import java.awt.event.ItemEvent;
import qlProject.gui.InputInterpreter;

public class CheckBoxToBasicQuestionListener extends InputItemListener {

	public CheckBoxToBasicQuestionListener(String observed, InputInterpreter interpreter){	
		super(observed, interpreter);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		interpreter.updateInputValue(observed);
	}
}
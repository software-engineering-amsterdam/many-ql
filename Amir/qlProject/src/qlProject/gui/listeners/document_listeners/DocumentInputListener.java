package qlProject.gui.listeners.document_listeners;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import qlProject.gui.InputInterpreter;

public abstract class DocumentInputListener implements DocumentListener{

	protected final String observed;
	protected final InputInterpreter interpreter;
	
	public DocumentInputListener(String observed, InputInterpreter interpreter) {
		this.observed = observed;
		this.interpreter = interpreter;
	}


	public void changedUpdate(DocumentEvent arg0) {
		notifyChange();
	}

	public void insertUpdate(DocumentEvent arg0) {
		notifyChange();
	}

	public void removeUpdate(DocumentEvent arg0) {
		notifyChange();	
	}

	public abstract void notifyChange();
	
}
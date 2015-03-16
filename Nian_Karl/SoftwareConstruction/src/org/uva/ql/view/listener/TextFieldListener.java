package org.uva.ql.view.listener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import org.uva.ql.ast.value.StrValue;

public class TextFieldListener implements DocumentListener {

	protected WidgetListener widgetListener;
	protected String identifier;

	public TextFieldListener(WidgetListener widgetListener, String identifier) {
		super();
		this.widgetListener = widgetListener;
		this.identifier = identifier;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		notifyListener(e);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		notifyListener(e);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
	}

	public void notifyListener(DocumentEvent e) {
		String s;
		try {
			System.out.println("Yoooo. TextfieldListener");
			s = e.getDocument().getText(0, e.getDocument().getLength());
			widgetListener.widgetValueChanged(identifier, new StrValue(s));
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		}
	}
}

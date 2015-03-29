package org.uva.ql.view.listener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.value.StrValue;

public class TextFieldListener implements DocumentListener {

	protected WidgetListener widgetListener;
	protected Identifier identifier;

	public TextFieldListener(WidgetListener widgetListener, Identifier identifier) {
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
			s = e.getDocument().getText(0, e.getDocument().getLength());
			widgetListener.widgetValueChanged(identifier, new StrValue(s));
		} catch (BadLocationException e1) {
			throw new IndexOutOfBoundsException("Index is out of bound at number textfield listener");
		}
	}
}

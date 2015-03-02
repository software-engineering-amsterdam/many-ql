package org.uva.ql.view.widgit;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import org.uva.ql.ast.value.Str;
import org.uva.ql.view.listener.WidgetListener;

public abstract class BaseTextField extends Widget implements DocumentListener {

	private JTextField jTextField;
	private WidgetListener widgetListener;
	private static final long serialVersionUID = 1L;

	public BaseTextField(WidgetListener listener) {
		this.jTextField = new JTextField();
		this.widgetListener = listener;
		jTextField.setPreferredSize(new Dimension(100, 25));
		jTextField.getDocument().addDocumentListener(this);
		jTextField.setVisible(true);
	}

	@Override
	public JComponent getWidget() {
		return jTextField;
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
		System.out.println("When does this trigger?..");
	}

	private void notifyListener(DocumentEvent e) {
		String s;
		try {
			s = e.getDocument().getText(0, e.getDocument().getLength());
			widgetListener.widgetValueChanged(getIdentifier(), new Str(s));
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		}
	}
}

package org.uva.ql.view.widgit;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import org.uva.ql.ast.type.UndefinedType;
import org.uva.ql.ast.value.StrValue;
import org.uva.ql.ast.value.UndefinedValue;
import org.uva.ql.ast.value.Value;
import org.uva.ql.view.listener.WidgetListener;

public abstract class BaseTextField extends Widget implements DocumentListener{

	protected final JTextField textField;
	protected final WidgetListener widgetListener;
	protected DocumentFilter documentFilter;

	public BaseTextField(WidgetListener listener) {
		super();
		this.documentFilter = new DocumentFilter();
		this.textField = new JTextField();
		this.widgetListener = listener;
		textField.setPreferredSize(new Dimension(100, 25));
		if (!isDependent()) {
			textField.getDocument().addDocumentListener(this);
		}
		textField.setVisible(true);
	}

	@Override
	public JTextField getWidget() {
		return textField;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if (!isDependent()) {
			notifyListener(e);
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (!isDependent()) {
			notifyListener(e);
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
	}

	public void notifyListener(DocumentEvent e) {
		String s;
		try {
			s = e.getDocument().getText(0, e.getDocument().getLength());
			widgetListener.widgetValueChanged(getIdentifier(), new StrValue(s));
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		}
	}

	@Override
	public void setWidgetValue(Value value) {
		if (!value.getType().isEqual(new UndefinedType())) {
			getWidget().setText(value.toString());
		}
	}
}
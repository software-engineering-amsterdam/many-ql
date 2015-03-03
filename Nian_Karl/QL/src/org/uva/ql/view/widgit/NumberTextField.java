package org.uva.ql.view.widgit;

import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;

import org.uva.ql.ast.value.Int;
import org.uva.ql.view.listener.WidgetListener;

public class NumberTextField extends BaseTextField {

	private static final long serialVersionUID = -158503348332039721L;

	public NumberTextField(WidgetListener listener) {
		super(listener);
	}

	@Override
	public Integer getValue() {
		return getValue();
	}

	public void notifyListener(DocumentEvent e) {
		int i;
		try {
			i = Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength()));
			widgetListener.widgetValueChanged(getIdentifier(), new Int(i));
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		}
	}
}

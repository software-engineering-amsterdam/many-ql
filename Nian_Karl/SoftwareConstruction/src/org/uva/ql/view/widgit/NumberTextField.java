package org.uva.ql.view.widgit;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;

import org.uva.ql.ast.value.IntValue;
import org.uva.ql.ast.value.UndefinedValue;
import org.uva.ql.view.listener.WidgetListener;

public class NumberTextField extends BaseTextField {

	private final String NUMBER_REGEX = "^[0-9]*$";
	public final Pattern p;

	public NumberTextField(WidgetListener listener) {
		super(listener);
		p = Pattern.compile(NUMBER_REGEX);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getValue() {
		return getValue();
	}

	public void notifyListener(DocumentEvent e) {
		try {
			String input = e.getDocument().getText(0, e.getDocument().getLength());
			Matcher m = p.matcher(input);
			if (input.equals("") || input == null) {
				widgetListener.widgetValueChanged(getIdentifier(), new UndefinedValue());
			} else if (m.matches()) {
				textField.setForeground(Color.black);
				int i = Integer.parseInt(input);
				widgetListener.widgetValueChanged(getIdentifier(), new IntValue(i));
			} else {
				textField.setForeground(Color.red);
			}
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		} catch (NumberFormatException e2) {
			System.out.println("apparently an exception.");
		}
	}
}

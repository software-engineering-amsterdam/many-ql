package org.uva.ql.view.listener;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import org.uva.ql.ast.value.IntValue;
import org.uva.ql.ast.value.UndefinedValue;
import org.uva.ql.view.widgit.BaseTextField;

public class NumberTextFieldListener implements DocumentListener {

	private final BaseTextField textField;
	private final String NUMBER_REGEX = "^[0-9]*$";
	public final Pattern p;
	private final WidgetListener widgetListener;
	private final String identifier;

	public NumberTextFieldListener(WidgetListener widgetListener, String identifier, BaseTextField textField) {
		this.widgetListener = widgetListener;
		this.identifier = identifier;
		this.textField = textField;
		p = Pattern.compile(NUMBER_REGEX);
	}

	public void notifyListener(DocumentEvent e) {
		System.out.println("Yooooo numer textfield");
		try {
			String input = e.getDocument().getText(0, e.getDocument().getLength());
			Matcher m = p.matcher(input);
			if (input.length() == 0) {
				widgetListener.widgetValueChanged(identifier, new UndefinedValue());
			} else if (m.matches()) {
				textField.setForegroundColor(Color.black);
				widgetListener.widgetValueChanged(identifier, new IntValue(Integer.parseInt(input)));
			} else {
				textField.setForegroundColor(Color.red);
			}
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		} catch (NumberFormatException e2) {
			System.out.println("apparently an exception.");
		}
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

}

package org.uva.ql.view.widgit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;

import org.uva.ql.ast.value.Int;
import org.uva.ql.ast.value.Undefined;
import org.uva.ql.ast.value.Value;
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
			if (m.matches() && !input.equals("")) {
				int i = Integer.parseInt(input);
				widgetListener.widgetValueChanged(getIdentifier(), new Int(i));
			}
		} catch (BadLocationException e1) {
			System.out.println("Something went terribly wrong.");
		} catch (NumberFormatException e2) {
			System.out.println("apparently an exception.");
		}
	}
}

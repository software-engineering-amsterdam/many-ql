package org.uva.ql.view.widgit;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.view.listener.NumberTextFieldListener;
import org.uva.ql.view.listener.WidgetListener;

public class NumberTextField extends BaseTextField {

	private final WidgetListener widgetListener;

	public NumberTextField(WidgetListener listener) {
		super(listener);
		this.widgetListener = listener;
		textField.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getValue() {
		return textField.getText();
	}

	@Override
	public void setIdentifier(Identifier identifier) {
		super.setIdentifier(identifier);
		NumberTextFieldListener textFieldListener = new NumberTextFieldListener(widgetListener, getIdentifier(), this);
		textField.getDocument().addDocumentListener(textFieldListener);

	}
}

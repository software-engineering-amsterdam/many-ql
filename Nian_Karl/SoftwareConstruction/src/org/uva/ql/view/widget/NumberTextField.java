package org.uva.ql.view.widget;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.value.Value;
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

	@Override
	public void setWidgetValue(Value value) {
		if (value.isDefined()) {
			textField.setText(value.toString());
		} else {
			textField.setText("");
		}
	}
}

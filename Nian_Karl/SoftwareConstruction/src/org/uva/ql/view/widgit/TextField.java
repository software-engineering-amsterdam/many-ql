package org.uva.ql.view.widgit;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.type.UndefinedType;
import org.uva.ql.ast.value.Value;
import org.uva.ql.view.listener.TextFieldListener;
import org.uva.ql.view.listener.WidgetListener;

public class TextField extends BaseTextField {

	private final WidgetListener widgetListener;

	public TextField(WidgetListener listener) {
		super(listener);
		this.widgetListener = listener;

	}

	@SuppressWarnings("unchecked")
	@Override
	public String getValue() {
		return getValue();
	}

	@Override
	public void setWidgetValue(Value value, Type type) {
		if (!type.isEqual(new UndefinedType())) {
			getWidget().setText(value.toString());
		}
	}

	@Override
	public void setIdentifier(Identifier identifier) {
		super.setIdentifier(identifier);
		TextFieldListener textFieldListener = new TextFieldListener(widgetListener, getIdentifier());
		textField.getDocument().addDocumentListener(textFieldListener);
	}
}

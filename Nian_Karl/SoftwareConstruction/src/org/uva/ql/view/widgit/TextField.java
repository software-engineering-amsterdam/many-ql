package org.uva.ql.view.widgit;

import org.uva.ql.ast.value.Undefined;
import org.uva.ql.ast.value.Value;
import org.uva.ql.view.listener.WidgetListener;

public class TextField extends BaseTextField {

	public TextField(WidgetListener listener) {
		super(listener);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getValue() {
		return getValue();
	}

	@Override
	public void setWidgetValue(Value value) {
		if (!value.toString().equals(new Undefined().toString())) {
			getWidget().setText(value.toString());
		}
	}
}

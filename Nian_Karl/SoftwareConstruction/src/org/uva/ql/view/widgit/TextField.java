package org.uva.ql.view.widgit;

import org.uva.ql.ast.type.UndefinedType;
import org.uva.ql.ast.value.UndefinedValue;
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
		if (!value.getType().isEqual(new UndefinedType()) && isDependent()) {
			getWidget().setText(value.toString());
		}
	}
}

package org.uva.ql.view.listener;

import org.uva.ql.ast.value.Value;

public abstract class WidgetListener implements IWidgetListener {

	@Override
	public abstract void widgetValueChanged(String identifier, Value value);

}

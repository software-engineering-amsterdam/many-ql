package org.uva.ql.view.listener;

import org.uva.ql.ast.value.Value;

public interface IWidgetListener {
	public abstract void widgetValueChanged(String identifier, Value value);
}

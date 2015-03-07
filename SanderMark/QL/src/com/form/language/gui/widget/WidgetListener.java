package com.form.language.gui.widget;

import com.form.language.ast.values.GenericValue;

public abstract class WidgetListener {
	public abstract void widgetValueChanged(String identifier, GenericValue value);
}

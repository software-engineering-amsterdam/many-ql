package qls.gui;

import ql.gui.UIComponent;

public interface WidgetFactory {
	public UIComponent create(WidgetBuilder builder);
}

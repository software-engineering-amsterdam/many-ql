package qls.gui.factory;

import ql.gui.UIComponent;
import qls.gui.WidgetBuilder;
import qls.gui.WidgetFactory;

public class SpinboxFactory implements WidgetFactory {
	@Override
	public UIComponent create(WidgetBuilder builder) {
		return builder.createSpinbox();
	}
}

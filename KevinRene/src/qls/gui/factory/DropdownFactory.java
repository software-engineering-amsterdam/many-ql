package qls.gui.factory;

import ql.value.StringValue;
import qls.ast.expression.Literal;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.WidgetFactory;
import qls.gui.widget.InputWidget;

public class DropdownFactory implements WidgetFactory {
	private Literal<StringValue> trueValue, falseValue;
	
	@SuppressWarnings("unchecked")
	public DropdownFactory(Literal<?> trueValue, Literal<?> falseValue) {
		this.trueValue = (Literal<StringValue>) trueValue;
		this.falseValue = (Literal<StringValue>) falseValue;
	}
	
	@Override
	public InputWidget<?> create(WidgetBuilder builder, StyleProperties properties) {
		return builder.createDropdown(properties, trueValue.getValue(), falseValue.getValue());
	}
}

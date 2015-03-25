package qls.gui.factory;

import ql.value.IntegerValue;
import qls.ast.expression.Literal;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.WidgetFactory;
import qls.gui.widget.InputWidget;

public class SliderFactory implements WidgetFactory {
	private Literal<IntegerValue> minValue, maxValue;
	
	@SuppressWarnings("unchecked")
	public SliderFactory(Literal<?> trueValue, Literal<?> falseValue) {
		this.minValue = (Literal<IntegerValue>) trueValue;
		this.maxValue = (Literal<IntegerValue>) falseValue;
	}
	
	@Override
	public InputWidget<?> create(WidgetBuilder builder, StyleProperties properties) {
		return builder.createSlider(properties, minValue.getValue(), maxValue.getValue());
	}
}

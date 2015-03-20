package qls.gui.builder;

import ql.ast.QLType;
import ql.ast.type.QLFloat;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.widget.InputWidget;
import qls.gui.widget.input.field.FloatField;
import qls.gui.widget.input.spinbox.FloatSpinbox;

public class FloatWidgetBuilder implements WidgetBuilder {
	@Override
	public InputWidget<?> createCheckbox(StyleProperties properties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createDropdown(StyleProperties properties, StringValue trueValue, StringValue falseValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createRadioButton(StyleProperties properties, StringValue trueValue, StringValue falseValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createSlider(StyleProperties properties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createSpinbox(StyleProperties properties) {
		return new FloatSpinbox();
	}

	@Override
	public InputWidget<?> createTextField(StyleProperties properties) {
		return new FloatField();
	}
	
	@Override
	public QLType getBuilderType() {
		return new QLFloat();
	}
}

package qls.gui.builder;

import ql.ast.QLType;
import ql.ast.type.QLBoolean;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.widget.InputWidget;
import qls.gui.widget.input.Dropdown;
import qls.gui.widget.input.Radio;

public class BooleanWidgetBuilder implements WidgetBuilder {
	@Override
	public InputWidget<?> createCheckbox(StyleProperties properties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createDropdown(StyleProperties properties, StringValue trueValue, StringValue falseValue) {
		return new Dropdown(trueValue, falseValue);
	}

	@Override
	public InputWidget<?> createRadioButton(StyleProperties properties) {
		return new Radio();
	}

	@Override
	public InputWidget<?> createSlider(StyleProperties properties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createSpinbox(StyleProperties properties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createTextField(StyleProperties properties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public QLType getBuilderType() {
		return new QLBoolean();
	}
}

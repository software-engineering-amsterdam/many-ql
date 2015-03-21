package qls.gui.builder;

import ql.ast.QLType;
import ql.ast.type.QLBoolean;
import ql.value.IntegerValue;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.widget.InputWidget;
import qls.gui.widget.input.Checkbox;
import qls.gui.widget.input.Dropdown;
import qls.gui.widget.input.Radio;

public class BooleanWidgetBuilder implements WidgetBuilder {
	@Override
	public InputWidget<?> createCheckbox(StyleProperties properties) {
		InputWidget<?> checkBox = new Checkbox();
		
		checkBox.setStyle(properties);
		
		return checkBox;
	}

	@Override
	public InputWidget<?> createDropdown(StyleProperties properties, StringValue trueValue, StringValue falseValue) {
		InputWidget<?> dropdown = new Dropdown(trueValue, falseValue);
		
		dropdown.setStyle(properties);
		
		return dropdown;
	}

	@Override
	public InputWidget<?> createRadioButton(StyleProperties properties, StringValue trueValue, StringValue falseValue) {
		InputWidget<?> radioButton = new Radio(trueValue, falseValue);
		
		radioButton.setStyle(properties);
		
		return radioButton;
	}

	@Override
	public InputWidget<?> createSlider(StyleProperties properties, IntegerValue minValue, IntegerValue maxValue) {
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

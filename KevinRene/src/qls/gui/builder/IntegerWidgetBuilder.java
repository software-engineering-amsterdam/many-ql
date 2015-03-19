package qls.gui.builder;

import ql.ast.QLType;
import ql.ast.type.QLInteger;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.widget.InputWidget;
import qls.gui.widget.input.field.IntegerField;
import qls.gui.widget.input.spinbox.IntegerSpinbox;

public class IntegerWidgetBuilder implements WidgetBuilder {
	@Override
	public InputWidget<?> createCheckbox(StyleProperties properties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createDropdown(StyleProperties properties, StringValue trueValue, StringValue falseValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createRadioButton(StyleProperties properties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createSlider(StyleProperties properties) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createSpinbox(StyleProperties properties) {
		return new IntegerSpinbox();
	}

	@Override
	public InputWidget<?> createTextField(StyleProperties properties) {
		return new IntegerField();
	}
	
	@Override
	public QLType getBuilderType() {
		return new QLInteger();
	}
}

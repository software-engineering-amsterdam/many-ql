package qls.gui.builder;

import ql.ast.QLType;
import ql.ast.type.QLString;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.widget.InputWidget;
import qls.gui.widget.input.field.TextField;

public class StringWidgetBuilder implements WidgetBuilder {
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
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createTextField(StyleProperties properties) {
		return new TextField();
	}
	
	@Override
	public QLType getBuilderType() {
		return new QLString();
	}
}

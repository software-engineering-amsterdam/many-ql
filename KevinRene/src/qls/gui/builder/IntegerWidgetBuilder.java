package qls.gui.builder;

import ql.ast.QLType;
import ql.ast.type.QLInteger;
import ql.value.IntegerValue;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.widget.InputWidget;
import qls.gui.widget.input.field.IntegerField;
import qls.gui.widget.input.slider.IntegerSlider;
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
	public InputWidget<?> createRadioButton(StyleProperties properties, StringValue trueValue, StringValue falseValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public InputWidget<?> createSlider(StyleProperties properties, IntegerValue minValue, IntegerValue maxValue) {
		InputWidget<?> slider = new IntegerSlider((IntegerValue) minValue, (IntegerValue) maxValue);
		
		slider.setStyle(properties);
		
		return slider;
	}

	@Override
	public InputWidget<?> createSpinbox(StyleProperties properties) {
		InputWidget<?> spinbox =  new IntegerSpinbox();
		
		spinbox.setStyle(properties);
		
		return spinbox;
	}

	@Override
	public InputWidget<?> createTextField(StyleProperties properties) {
		InputWidget<?> field = new IntegerField();
		
		field.setStyle(properties);
		
		return field;
	}
	
	@Override
	public QLType getBuilderType() {
		return new QLInteger();
	}
}

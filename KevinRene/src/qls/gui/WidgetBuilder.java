package qls.gui;

import ql.ast.QLType;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.InputWidget;

public interface WidgetBuilder {
	public InputWidget<?> createCheckbox(StyleProperties properties);
	public InputWidget<?> createDropdown(StyleProperties properties, StringValue trueValue, StringValue falseValue);
	public InputWidget<?> createRadioButton(StyleProperties properties);
	public InputWidget<?> createSlider(StyleProperties properties);
	public InputWidget<?> createSpinbox(StyleProperties properties);
	public InputWidget<?> createTextField(StyleProperties properties);
	
	public QLType getBuilderType();
}

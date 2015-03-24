package qls.gui.widget.input;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ql.gui.DefaultChangeHandler;
import ql.value.BooleanValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.InputWidget;
import qls.gui.widget.WidgetStylizer;

public class Checkbox extends DefaultChangeHandler implements InputWidget<BooleanValue> {
	private WidgetStylizer stylizer;
	private JCheckBox checkBox;
	
	public Checkbox() {
		stylizer = new WidgetStylizer();
		checkBox = new JCheckBox();
	}
	public Checkbox(BooleanValue value) {
		this();
		checkBox.setSelected(value.getValue());
	}

	@Override
	public void disable() {
		checkBox.setEnabled(false);
	}

	@Override
	public void setValue(BooleanValue value) {
		checkBox.setSelected(value.getValue());
	}

	@Override
	public BooleanValue getValue() {
		return new BooleanValue(checkBox.isSelected());
	}

	@Override
	public void updateComponent() {
		handleChange(getValue(), this);
	}

	@Override
	public JComponent getComponent() {
		return checkBox;
	}

	@Override
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(getComponent(), properties);
	}

}

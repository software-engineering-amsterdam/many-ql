package qls.gui.widget.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ql.gui.DefaultComponent;
import ql.value.BooleanValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.InputWidget;
import qls.gui.widget.WidgetStylizer;

public class Checkbox extends DefaultComponent implements InputWidget<BooleanValue>, ActionListener {
	private WidgetStylizer stylizer;
	private JCheckBox checkBox;
	
	public Checkbox() {
		stylizer = new WidgetStylizer();
		checkBox = new JCheckBox();
		checkBox.addActionListener(this);
	}
	public Checkbox(BooleanValue value) {
		this();
		checkBox.setSelected(value.getPrimitive());
	}

	@Override
	public void disable() {
		checkBox.setEnabled(false);
	}

	@Override
	public void setValue(BooleanValue value) {
		checkBox.setSelected(value.getPrimitive());
	}

	@Override
	public BooleanValue getValue() {
		return new BooleanValue(checkBox.isSelected());
	}

	@Override
	public void updateComponent() {
		checkBox.repaint();
	}

	@Override
	public JComponent getComponent() {
		return checkBox;
	}

	@Override
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(getComponent(), properties);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		handleChange(getValue(), this);
	}
}

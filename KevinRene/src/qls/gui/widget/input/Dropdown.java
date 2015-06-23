package qls.gui.widget.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import ql.gui.DefaultComponent;
import ql.value.BooleanValue;
import ql.value.StringValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.InputWidget;
import qls.gui.widget.WidgetStylizer;

public class Dropdown extends DefaultComponent implements InputWidget<BooleanValue>, ActionListener {
	private WidgetStylizer stylizer;
	private JComboBox<String> comboBox;
	private String[] labels;
	
	public Dropdown(StringValue trueValue, StringValue falseValue) {
		stylizer = new WidgetStylizer();
		labels = new String[]{trueValue.getPrimitive(), falseValue.getPrimitive()};
		
		comboBox = new JComboBox<String>(labels);
		comboBox.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		handleChange(getValue(), this);
	}

	@Override
	public void disable() {
		comboBox.setEnabled(false);
	}

	@Override
	public void setValue(BooleanValue value) {
		comboBox.setSelectedItem(value.toString());
	}

	@Override
	public BooleanValue getValue() {
		switch (comboBox.getSelectedIndex()) {
			case 0 : return new BooleanValue(true);
			default : return new BooleanValue(false);
		}
	}

	@Override
	public void updateComponent() {
		comboBox.revalidate();
		comboBox.repaint();
	}

	@Override
	public JComponent getComponent() {
		return comboBox;
	}

	@Override
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(comboBox, properties);
	}
}

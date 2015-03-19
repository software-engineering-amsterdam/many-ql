package qls.gui.widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import ql.gui.widget.InputWidget;
import ql.value.BooleanValue;
import ql.value.StringValue;

public class Dropdown extends InputWidget<BooleanValue> implements ActionListener {

	protected JComboBox<String> comboBox;
	private String[] labels;
	
	public Dropdown(StringValue tru, StringValue fls) {
		labels = new String[]{tru.getValue(), fls.getValue()};
		
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
		comboBox.repaint();
	}

	@Override
	public JComponent getComponent() {
		return comboBox;
	}
}

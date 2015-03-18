package ql.gui.widget.input;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import net.miginfocom.swing.MigLayout;
import ql.gui.widget.InputWidget;
import ql.value.IntegerValue;

public class IntegerField extends InputWidget<IntegerValue> implements CaretListener {	
	protected JPanel container;
	protected JTextField textField;
	protected JLabel errorLabel;
	
	public IntegerField() {
		textField = new JTextField(50);
    	textField.setMaximumSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height * 2));
    	textField.setFont(new Font("Serif", Font.BOLD, 20));
    	textField.addCaretListener(this);
    	textField.setFocusable(true);
    	
    	errorLabel = new JLabel();
    	errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
    	errorLabel.setVisible(true);
    	
    	container = new JPanel(new MigLayout());
    	container.add(textField);
    	container.add(errorLabel, "wrap");
	}
	
	public IntegerField (IntegerValue stringValue) {
		this();		
    	textField.setText(stringValue.getValue().toString());	
	}
	
	public void setError(String text) {
		textField.setBorder(BorderFactory.createLineBorder(Color.RED));
		errorLabel.setText(text);
	}
	
	public void removeError() {
		textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		errorLabel.setText("");
	}
	
	@Override
	public void disable() {
		textField.setEnabled(false);
	}

	@Override
	public IntegerValue getValue() {
		return new IntegerValue(Integer.parseInt(textField.getText()));
	}
	
	@Override
	public void setValue(IntegerValue value) {
		textField.setText(value.toString());		
	}

	@Override
	public void updateComponent() {
		textField.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return this.container;
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		try {
			handleChange(getValue(), this);
			removeError();
		}
		catch (NumberFormatException nfe) {
			setError("Not a valid integer");
		}
	}
}

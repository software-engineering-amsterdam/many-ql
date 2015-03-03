package gui.widget.input;

import gui.widget.InputWidget;

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
import cons.value.StringValue;

public class TextField extends InputWidget<StringValue> implements CaretListener {	
	protected JPanel container;
	protected JTextField textField;
	protected JLabel errorLabel;
	
	public TextField() {
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
	
	public TextField (StringValue stringValue) {
		this();		
    	textField.setText(stringValue.getValue());	
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
	public StringValue getValue() {
		return new StringValue(textField.getText());
	}
	
	@Override
	public void setValue(StringValue value) {
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
		handleChange(getValue());
	}
}

package gui.widget;

import gui.Widget;

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

public class TextField extends Widget<StringValue> implements CaretListener {	
	protected JPanel container;
	protected JTextField textField;
	protected JLabel errorLabel;
	
	public TextField() {
		textField = new JTextField(100);
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
		textField = new JTextField(100);
    	textField.setMaximumSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height * 2));
    	textField.setFont(new Font("Serif", Font.BOLD, 20));
    	textField.addCaretListener(this);
    	textField.setFocusable(true);
    	textField.setText(stringValue.getValue());
    	
    	errorLabel = new JLabel();
    	errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
    	errorLabel.setVisible(true);
    	
    	container = new JPanel(new MigLayout());
    	container.add(textField);
    	container.add(errorLabel, "wrap");		
	}

	@Override
	public JComponent getComponent() {
		return this.container;
	}

	@Override
	public StringValue getValue() {
		return new StringValue(textField.getText());
	}
	
	@Override
	public void setValue(StringValue value) {
		// Update value of the JComponent
		textField.setText(value.toString());
		
		setChanged();
		notifyObservers();
	}
	
	protected void setError(String text) {
		textField.setBorder(BorderFactory.createLineBorder(Color.RED));
		errorLabel.setText(text);
	}
	
	protected void removeError() {
		textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		errorLabel.setText("");
	}

	@Override
	public void caretUpdate(CaretEvent e) {		
		setChanged();
		notifyObservers();
	}
}

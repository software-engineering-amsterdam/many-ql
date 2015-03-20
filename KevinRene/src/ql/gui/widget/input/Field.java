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
import ql.Value;
import ql.gui.DefaultChangeHandler;
import ql.gui.widget.InputWidget;

public abstract class Field<T extends Value> extends DefaultChangeHandler implements InputWidget<T>, CaretListener {	
	protected JPanel container;
	protected JTextField textField;
	protected JLabel errorLabel;
	
	protected T value;
	
	public Field(T initialValue) {
		textField = new JTextField(50);
    	textField.setMaximumSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height * 2));
    	textField.setFont(new Font("Serif", Font.BOLD, 20));

    	setValue(initialValue);
    	
    	textField.addCaretListener(this);
    	textField.setFocusable(true);
    	
    	errorLabel = new JLabel();
    	errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
    	errorLabel.setVisible(true);
    	
    	container = new JPanel(new MigLayout());
    	container.add(textField);
    	container.add(errorLabel, "wrap");
    	
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
	public void disable() {
		textField.setEnabled(false);
	}
	
	@Override
	public void updateComponent() {
		textField.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return this.container;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
		textField.setText(value.getValue().toString());		
	}
	
	public abstract void caretUpdate(CaretEvent e);
	protected abstract T getFieldValue() throws NumberFormatException;
}

package ql.gui.widget.input;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import net.miginfocom.swing.MigLayout;
import ql.Value;
import ql.gui.DefaultComponent;
import ql.gui.widget.InputWidget;

public abstract class Field<T extends Value> extends DefaultComponent implements InputWidget<T>, CaretListener {	
	private JPanel panel;
	private JTextField textField;
	private JLabel errorLabel;
	
	private T value;
	
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
    	
    	panel = new JPanel(new MigLayout());
    	panel.add(textField);
    	panel.add(errorLabel, "wrap");
	}
	
	protected final T value() {
		return value;
	}
	
	protected final void value(T value) {
		this.value = value;
	}
		
	protected void setError(String text) {
		textField.setBorder(BorderFactory.createLineBorder(Color.RED));
		errorLabel.setText(text);
	}
	
	/**
	 * Exposes the internal JPanel for adjustements
	 * by extending classes. It cannot be overriden 
	 * and is marked 'final'.
	 * 
	 * @return The internal panel.
	 */
	protected final JPanel panel() {
		return panel;
	}
	
	/**
	 * Exposes the internal JTextField for adjustements
	 * by extending classes. It cannot be overriden
	 * and is marked 'final'.
	 * 
	 * @return The internal textfield.
	 */
	protected final JTextField textField() {
		return textField;
	}
	
	/**
	 * Exposes the internal JLabel for adjustements
	 * by extending classes. It cannot be overriden 
	 * and is marked 'final'.
	 * 
	 * The label is used to present errors by default.
	 * 
	 * @return The internal label.
	 */
	protected final JLabel label() {
		return errorLabel;
	}
	
	protected abstract T getFieldValue() throws ParseException;
	
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
		return this.panel;
	}
	
	@Override
	public T getValue() {
		return value;
	}
	
	@Override
	public void setValue(T value) {
		this.value = value;
		textField.setText(value.getPrimitive().toString());		
	}
	
	@Override
	public abstract void caretUpdate(CaretEvent e);
}

package ql.gui.widget.input;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;
import ql.Value;
import ql.gui.DefaultComponent;
import ql.gui.widget.InputWidget;

public abstract class Spinbox<T extends Value> extends DefaultComponent implements InputWidget<T>, ChangeListener {
	private JPanel panel;
	private JSpinner spinbox;
	private JLabel errorLabel;
	private SpinnerNumberModel model;
	
	public Spinbox(SpinnerNumberModel model) {
		this.model = model;
		
		spinbox = new JSpinner(model);
		spinbox.setSize(100, 40);
		spinbox.addChangeListener(this);
		
		errorLabel = new JLabel();
    	errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
    	errorLabel.setVisible(true);
    	
    	panel = new JPanel(new MigLayout());
    	panel.add(spinbox);
    	panel.add(errorLabel, "wrap");
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
	 * Exposes the internal JSpinner for adjustements
	 * by extending classes. It cannot be overriden
	 * and is marked 'final'.
	 * 
	 * @return The internal spinbox.
	 */
	protected final JSpinner spinbox() {
		return spinbox;
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
	
	/**
	 * Exposes the internal SpinnerNumberModel for adjustements
	 * by extending classes. It cannot be overriden and is marked 
	 * 'final'.
	 * 
	 * @return The internal SpinnerNumberModel.
	 */
	protected final SpinnerNumberModel model() {
		return model;
	}
	
	protected void setError(String text) {
		spinbox.setBorder(BorderFactory.createLineBorder(Color.RED));
		errorLabel.setText(text);
	}
	
	protected void removeError() {
		spinbox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		errorLabel.setText("");
	}
	
	@Override
	public void disable() {
		spinbox.setEnabled(false);
	}
	
	@Override
	public abstract T getValue(); 
	
	/**
	 * This method is overriden to cast the given value
	 * that is a numeric to the wanted type. Either 
	 * integer or float.
	 * 
	 * @param value - The value to convert.
	 * @return The converted value wrapped in the proper
	 * 		value object.
	 */
	public abstract Number convertValue(Value value);
	
	@Override
	public void setValue(Value value) {
		spinbox.setValue(convertValue(value));
	}
	
	@Override
	public void updateComponent() {
		spinbox.repaint();
	}

	@Override
	public JComponent getComponent() {
		return spinbox;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		handleChange(getValue(), this);
	}
}

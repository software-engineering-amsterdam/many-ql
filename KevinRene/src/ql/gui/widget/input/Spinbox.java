package ql.gui.widget.input;

import java.awt.Color;
import java.awt.Component;
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
import ql.gui.widget.InputWidget;

public abstract class Spinbox<T extends Value> extends InputWidget<T> implements ChangeListener {
	protected JPanel container;
	protected JSpinner spinbox;
	protected JLabel errorLabel;
	protected SpinnerNumberModel model;
	
	public Spinbox(SpinnerNumberModel model) {
		this.model = model;
		
		spinbox = new JSpinner(model);
		spinbox.setSize(100, 40);
		spinbox.addChangeListener(this);
//		spinbox.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		errorLabel = new JLabel();
    	errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
    	errorLabel.setVisible(true);
    	
    	container = new JPanel(new MigLayout());
    	container.add(spinbox);
    	container.add(errorLabel, "wrap");
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
	
	/**
	 * Very nasty hack to allow casting of any number into 
	 * the one that is actually supported by the spinbox.
	 * We only expect numeric values at this point, so we
	 * close our eyes to not see the ugliness.
	 * 
	 * At least it's documented....
	 * 
	 * Right? Please?
	 */
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

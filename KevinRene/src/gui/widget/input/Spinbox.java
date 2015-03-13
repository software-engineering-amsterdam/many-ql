package gui.widget.input;

import gui.widget.InputWidget;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ql.Value;

@SuppressWarnings("rawtypes")
public abstract class Spinbox<T extends Value> extends InputWidget<T> implements ChangeListener {
	protected JSpinner spinbox;
	
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
	public abstract Value convertValue(Value value);
	
	@Override
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
	public void setValue(T value) {
		spinbox.setValue(convertValue(value).getValue());
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
		handleChange(getValue());
	}
}

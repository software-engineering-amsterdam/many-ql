package gui.widgets;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.expression.Identifier;
import cons.value.BooleanValue;
import cons.value.IntegerValue;

public class IntegerSpinner extends Widget implements ChangeListener {
	
	private JSpinner spinner;
	private SpinnerNumberModel model;

	public IntegerSpinner(Identifier identifier, ValueEnvironment valueEnv) {
		super(identifier, valueEnv);
		
		model = new SpinnerNumberModel(
				0, //initial value
        		Integer.MIN_VALUE, //min
        		Integer.MAX_VALUE, //max
        		1
        	);
		
		spinner = new JSpinner(model);
		spinner.addChangeListener(this);
	}
	public IntegerSpinner(Identifier identifier, ValueEnvironment valueEnv, boolean enabled) {
		this(identifier, valueEnv);
		spinner.setEnabled(enabled);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Value value = new IntegerValue((int)model.getNumber());
		storeAndNotify(getIdentifier(), value);				
	}

	@Override
	public void setValue(Value value) {
		if (value.isUndefined()) {
			return;
		}

		spinner.setValue(((IntegerValue)value).getValue());
		storeAndNotify(getIdentifier(), value);
		
	}

	@Override
	public JComponent getComponent() {
		return spinner;
	}

}

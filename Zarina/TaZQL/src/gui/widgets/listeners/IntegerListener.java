package gui.widgets.listeners;

import evaluator.IntegerValue;
import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class IntegerListener extends AListener implements DocumentListener {
	//private final IWidgetComponent widget;
	private int value = 0;
	//private final ValueRepository valueRepository;
	
	public IntegerListener(IWidgetComponent widget, ValueRepository valueRepository) {
		super(widget, valueRepository);
		//this.widget = widget;
		//this.valueRepository = valueRepository;
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		update();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		update();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
	//	update();
	}
	
	@Override
	public void update() {
		try {
			value = Integer.valueOf(widget.getIntegerValue());
			IntegerValue intValue = new IntegerValue(value);
			
			valueRepository.putID(widget.getIdWidget().toString(), intValue);
			widget.getWidget().revalidate();
			widget.getWidget().repaint();
			System.out.println("Listener value: " + (valueRepository.getValue(widget.getIdWidget())).toString()   );
		}
		catch(NumberFormatException ex){
			System.err.println("Ilegal input: digits only!");
		}	
	}
}

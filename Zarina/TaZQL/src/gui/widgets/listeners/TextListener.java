package gui.widgets.listeners;

import evaluator.StringValue;
import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextListener implements DocumentListener {
	protected final IWidgetComponent widget;
	private String value = "";
	protected final ValueRepository valueRepository;
	
	public TextListener(IWidgetComponent widget, ValueRepository valueRepository) {
		this.widget = widget;
		this.valueRepository = valueRepository;
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
		update();
	}
	
	//@Override
	public void update() {
		value = widget.getStringValue().toString();
		StringValue stringValue = new StringValue(value);
		
		valueRepository.putID(widget.getIdWidget().toString(), stringValue);
		widget.getWidget().revalidate();
		widget.getWidget().repaint();
		System.out.println("Listener value: " + valueRepository.getValueRepository());
	}
}

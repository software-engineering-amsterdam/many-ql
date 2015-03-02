package gui.widgets;

import interpreter.StringValue;
import interpreter.ValueRepository;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextDigitsListener implements DocumentListener {
	private final IWidgetComponent widget;
	private String value = "";
	private final ValueRepository valueRepository;
	
	public TextDigitsListener(IWidgetComponent widget, ValueRepository valueRepository) {
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
		value = widget.getTextValue().toString();
		StringValue stringValue = new StringValue(value);
		
		valueRepository.putID(widget.getIdWidget().toString(), stringValue);
		widget.getWidget().revalidate();
		widget.getWidget().repaint();
		System.out.println("Listener value: " + valueRepository.getValueRepository() + " , id: " + widget.getIdWidget());
	}
}

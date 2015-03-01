package gui.widgets;

import gui.questions.IConnector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextDigitsListener implements DocumentListener {
	private final IWidgetComponent widget;
	private String id = "";
	private String value = "";
	IConnector connect;
	
	public TextDigitsListener(IWidgetComponent widget, String id) {
		this.widget = widget;
		this.id = id;
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
		//widget.addDocListener();
		value = widget.getValue();
		widget.getWidget().revalidate();
		widget.getWidget().repaint();
		//widget.setValue(value);
		System.out.println("Listener value: " + value + " , id: " + widget.getIdWidget());
		//widget.setValue(widget.getValue());
	}

	public void updateV() {
		connect.setValue(widget.getValue());
		//System.out.println("Updating");
	}
}

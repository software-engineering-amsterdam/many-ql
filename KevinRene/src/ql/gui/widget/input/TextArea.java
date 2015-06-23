package ql.gui.widget.input;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import ql.gui.DefaultComponent;
import ql.gui.widget.InputWidget;
import ql.value.StringValue;

public class TextArea extends DefaultComponent implements InputWidget<StringValue>, CaretListener {	
	private JTextArea textArea;
	
	public TextArea() {
		textArea = new JTextArea();
    	textArea.addCaretListener(this);
    	textArea.setFocusable(true);
	}
	
	public TextArea (StringValue stringValue) {
		this();		
    	textArea.setText(stringValue.getPrimitive());	
	}
	
	@Override
	public void disable() {
		textArea.setEditable(false);
	}

	@Override
	public StringValue getValue() {
		return new StringValue(textArea.getText());
	}
	
	public void appendValue(StringValue value) {
		textArea.append(value.getPrimitive());
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	@Override
	public void setValue(StringValue value) {
		textArea.setText(value.getPrimitive());		
	}

	@Override
	public void updateComponent() {
		textArea.revalidate();
		textArea.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return textArea;
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		handleChange(getValue(), this);
	}
}

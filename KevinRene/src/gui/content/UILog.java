package gui.content;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ql.Value;
import gui.Widget;

public class UILog implements Widget {
	private Widget handler;
	
	private JScrollPane logScrollPane;
	private JTextArea log;
	
	public UILog() {
		log = new JTextArea();
		log.setEditable(false);
		logScrollPane = new JScrollPane(log);
	}
	
	public void appendMessage(String logMessage) {
		log.append(logMessage);
		log.setCaretPosition(log.getDocument().getLength());
	}

	@Override
	public void setHandler(Widget handler) {
		this.handler = handler;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue, Widget source) {
		handler.handleChange(changedValue, source);
	}

	@Override
	public void updateComponent() {		
		logScrollPane.revalidate();
		logScrollPane.repaint();
	}

	@Override
	public JComponent getComponent() {
		return logScrollPane;
	}
}

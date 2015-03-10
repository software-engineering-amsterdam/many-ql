package gui.content;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ql.Value;
import gui.UIComponent;

public class UILog extends UIComponent {
	private UIComponent handler;
	
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

	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue, UIComponent source) {
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

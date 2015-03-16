package gui.content;

import gui.UIComponent;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UILog extends UIComponent {
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
	public void updateComponent() {		
		logScrollPane.revalidate();
		logScrollPane.repaint();
	}

	@Override
	public JComponent getComponent() {
		return logScrollPane;
	}
}

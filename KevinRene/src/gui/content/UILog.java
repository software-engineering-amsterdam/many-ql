package gui.content;

import javax.swing.JComponent;

import ql.gui.DefaultComponent;
import ql.gui.Component;
import ql.gui.structure.ScrollablePanel;
import ql.gui.widget.input.TextArea;
import ql.value.StringValue;

public class UILog extends DefaultComponent implements Component {
	private ScrollablePanel scrollableSection;
	private TextArea log;
	
	public UILog() {
		log = new TextArea();
		log.setHandler(this);
		log.disable();
		
		scrollableSection = new ScrollablePanel(this, log);
	}
	
	public UILog(Component handler) {
		this();
		setHandler(this);
	}
	
	public void clear() {
		log.setValue(new StringValue(""));
	}
	
	public void appendMessage(String logMessage) {
		log.appendValue(new StringValue(logMessage + "\n"));
	}

	@Override
	public void updateComponent() {		
		scrollableSection.updateComponent();
		log.updateComponent();
	}

	@Override
	public JComponent getComponent() {
		return scrollableSection.getComponent();
	}
}
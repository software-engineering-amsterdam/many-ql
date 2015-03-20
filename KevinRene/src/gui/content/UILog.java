package gui.content;

import javax.swing.JComponent;

import ql.gui.DefaultChangeHandler;
import ql.gui.UIComponent;
import ql.gui.structure.ScrollablePanel;
import ql.gui.widget.input.TextArea;
import ql.value.StringValue;

public class UILog extends DefaultChangeHandler implements UIComponent {
	private ScrollablePanel scrollableSection;
	private TextArea log;
	
	public UILog() {
		log = new TextArea();
		log.setHandler(this);
		log.disable();
		
		scrollableSection = new ScrollablePanel(this, log);
	}
	
	public void clear() {
		log.setValue(new StringValue(""));
	}
	
	public void appendMessage(StringValue logMessage) {
		log.appendValue(logMessage);
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

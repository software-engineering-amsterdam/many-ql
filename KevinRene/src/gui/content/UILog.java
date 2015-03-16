package gui.content;

import gui.UIComponent;
import gui.structure.ScrollableSection;
import gui.widget.input.TextArea;

import javax.swing.JComponent;

import ql.value.StringValue;

public class UILog extends UIComponent {
	private ScrollableSection scrollableSection;
	private TextArea log;
	
	public UILog() {
		log = new TextArea();
		log.setHandler(this);
		
		scrollableSection = new ScrollableSection(this, log);
	}
	
	// TODO: Wrap the string into the StringValue at the source.
	public void appendMessage(String logMessage) {
		log.appendValue(new StringValue(logMessage));
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

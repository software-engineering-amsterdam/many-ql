package ql.gui.content;

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
		
		scrollableSection = new ScrollablePanel(this, log);
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

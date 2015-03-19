package ql.gui.structure;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import ql.Value;
import ql.gui.UIComponent;

public class ScrollablePanel implements UIComponent {
	private JScrollPane scrollablePanel;
	private UIComponent handler;

	public ScrollablePanel(UIComponent content) {		
		scrollablePanel = new JScrollPane(content.getComponent());		
	}
	
	public ScrollablePanel(UIComponent handler, UIComponent content) {
		this(content);		
		setHandler(handler);
	}
	
	@Override
	public void updateComponent() {		
		scrollablePanel.revalidate();
		scrollablePanel.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return scrollablePanel;
	}
	
	@Override
	public void setHandler(UIComponent handler) {
		this.handler = handler;
	}

	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		handler.handleChange(changedValue, source);
	}
}

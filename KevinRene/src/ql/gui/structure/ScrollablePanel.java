package ql.gui.structure;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import ql.gui.UIComponent;

public class ScrollablePanel extends UIComponent {
	private JScrollPane scrollablePanel;

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
}

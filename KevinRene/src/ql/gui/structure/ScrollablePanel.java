package ql.gui.structure;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import ql.gui.UIComponent;

public class ScrollablePanel extends UIComponent {
	private JScrollPane scrollablePanel;

	public ScrollablePanel(UIComponent content) {		
		scrollablePanel = new JScrollPane(content.getComponent());
		scrollablePanel.setPreferredSize(new Dimension(800, 600));
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

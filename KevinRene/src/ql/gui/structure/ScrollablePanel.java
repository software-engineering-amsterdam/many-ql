package ql.gui.structure;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import ql.gui.DefaultComponent;
import ql.gui.Component;

public class ScrollablePanel extends DefaultComponent {
	private JScrollPane scrollablePanel;
	private Component content;

	public ScrollablePanel(Component content) {		
		scrollablePanel = new JScrollPane(content.getComponent());
		scrollablePanel.setPreferredSize(new Dimension(800, 600));
		
		this.content = content;
		this.content.setHandler(this);
	}
	
	public ScrollablePanel(Component handler, Component content) {
		this(content);		
		setHandler(handler);
	}
	
	@Override
	public void updateComponent() {
		content.updateComponent();
		
		scrollablePanel.revalidate();
		scrollablePanel.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return scrollablePanel;
	}
}

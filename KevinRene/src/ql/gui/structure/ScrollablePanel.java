package ql.gui.structure;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import ql.gui.DefaultChangeHandler;
import ql.gui.UIComponent;

public class ScrollablePanel extends DefaultChangeHandler implements UIComponent {
	private JScrollPane scrollablePanel;
	private UIComponent content;

	public ScrollablePanel(UIComponent content) {		
		scrollablePanel = new JScrollPane(content.getComponent());
		scrollablePanel.setPreferredSize(new Dimension(800, 600));
		
		this.content = content;
		this.content.setHandler(this);
	}
	
	public ScrollablePanel(UIComponent handler, UIComponent content) {
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

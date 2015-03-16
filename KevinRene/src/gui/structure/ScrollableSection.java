package gui.structure;

import gui.UIComponent;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class ScrollableSection extends UIComponent {
	private JScrollPane scrollablePanel;

	public ScrollableSection(UIComponent content) {		
		scrollablePanel = new JScrollPane(content.getComponent());		
	}
	
	public ScrollableSection(UIComponent handler, UIComponent content) {
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

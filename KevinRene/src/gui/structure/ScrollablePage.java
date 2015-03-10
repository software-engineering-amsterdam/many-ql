package gui.structure;

import gui.UIComponent;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class ScrollablePage extends UIComponent {
	private JScrollPane scrollablePanel;
	private List<UIComponent> components;
	
	public ScrollablePage() {		
		scrollablePanel = new JScrollPane();		
		components = new ArrayList<UIComponent>();
	}
	
	public ScrollablePage(UIComponent handler) {
		this();		
		setHandler(handler);
	}
	
	public void addComponent(UIComponent component) {
		components.add(component);
		
		scrollablePanel.add(component.getComponent());
		
		component.setHandler(this);
		component.getComponent().setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	@Override
	public void updateComponent() {
		for(UIComponent component : components) {
			component.updateComponent();
		}
		
		scrollablePanel.revalidate();
		scrollablePanel.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return scrollablePanel;
	}
}

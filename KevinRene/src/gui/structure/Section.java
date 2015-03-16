package gui.structure;

import gui.UIComponent;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Section extends UIComponent {
	private JPanel panel;
	private List<UIComponent> components;
	
	public Section() {		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		components = new ArrayList<UIComponent>();
	}
	
	public Section(UIComponent handler) {
		this();		
		setHandler(handler);
	}
	
	public void addComponent(UIComponent component) {
		components.add(component);
		
		panel.add(component.getComponent());
		
		component.setHandler(this);
		component.getComponent().setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	@Override
	public void updateComponent() {
		for(UIComponent component : components) {
			component.updateComponent();
		}
		
		panel.revalidate();
		panel.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return panel;
	}
}

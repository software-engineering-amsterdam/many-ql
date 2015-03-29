package ql.gui.structure;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import ql.gui.DefaultComponent;
import ql.gui.Component;

public class Panel extends DefaultComponent {
	private JPanel panel;
	private List<Component> components;
	
	public Panel() {		
		panel = new JPanel(new MigLayout("hidemode 3"));
		
		components = new ArrayList<Component>();
	}
	
	public Panel(Component handler) {
		this();		
		setHandler(handler);
	}
	
	protected JPanel getPanel() {
		return panel;
	}
	
	protected List<Component> getComponents() {
		return components;
	}
	
	public void addComponent(Component component) {
		addComponent(component, "wrap");
	}
	
	public void addComponent(Component component, String migSetting) {
		components.add(component);
		
		panel.add(component.getComponent(), migSetting);
		
		component.setHandler(this);
		component.getComponent().setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
	}
	
	@Override
	public void updateComponent() {
		for(Component component : components) {
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

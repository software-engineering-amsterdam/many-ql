package ql.gui.structure;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import ql.gui.DefaultChangeHandler;
import ql.gui.UIComponent;

public class Panel extends DefaultChangeHandler implements UIComponent {
	private JPanel panel;
	private List<UIComponent> components;
	
	public Panel() {		
		panel = new JPanel(new MigLayout("hidemode 3"));
//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		components = new ArrayList<UIComponent>();
	}
	
	public Panel(UIComponent handler) {
		this();		
		setHandler(handler);
	}
	
	public void addComponent(UIComponent component) {
		addComponent(component, "wrap");
	}
	public void addComponent(UIComponent component, String migSetting) {
		components.add(component);
		
		panel.add(component.getComponent(), migSetting);
		
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

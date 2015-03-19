package ql.gui.structure;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import ql.Value;
import ql.gui.UIComponent;

public class Panel implements UIComponent {
	private JPanel panel;
	private UIComponent handler;
	private List<UIComponent> components;
	
	public Panel() {		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		components = new ArrayList<UIComponent>();
	}
	
	public Panel(UIComponent handler) {
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
	
	@Override
	public void setHandler(UIComponent handler) {
		this.handler = handler;
	}

	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		handler.handleChange(changedValue, source);
	}
}

package gui.structure;

import gui.UIComponent;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel extends UIComponent {
	private JPanel panel;
	private List<UIComponent> widgets;
	
	public Panel() {		
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		
		this.widgets = new ArrayList<UIComponent>();
	}
	
	public Panel(UIComponent handler) {
		this();		
		setHandler(handler);
	}
	
	public void addComponent(UIComponent component) {
		widgets.add(component);
		
		panel.add(component.getComponent());
		
		component.setHandler(this);
		component.getComponent().setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	@Override
	public void updateComponent() {
		for(UIComponent widget : widgets) {
			widget.updateComponent();
		}
		
		panel.revalidate();
		panel.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return panel;
	}
}

package gui.widget.composite;

import gui.Widget;
import gui.widget.Composite;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import cons.ql.ast.expression.Identifier;

public class Panel extends Composite {
	private JPanel panel;
	private List<Widget> widgets;
	
	public Panel() {
		super(new Identifier("Panel"));
		
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		
		this.widgets = new ArrayList<Widget>();
	}
	
	public void addComponent(Widget component) {
		widgets.add(component);
		
		panel.add(component.getComponent());
		
		component.setHandler(this);
		component.getComponent().setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	@Override
	public void updateComponent() {
		for(Widget widget : widgets) {
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

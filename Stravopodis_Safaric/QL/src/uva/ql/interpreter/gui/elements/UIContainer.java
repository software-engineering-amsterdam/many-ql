package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JPanel;

import uva.ql.interpreter.gui.supporting.Size;

public class UIContainer{

	public JPanel randerContainer(Size size){
		JPanel panel = new JPanel();
		
		panel.setSize(size.getWidth(), size.getHeight());
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		return panel;
	}
	
	public JPanel addComponents(JPanel container, List<Component> components){
		for (Component component : components){
			container.add(component);
		}
		return container;
	}
}

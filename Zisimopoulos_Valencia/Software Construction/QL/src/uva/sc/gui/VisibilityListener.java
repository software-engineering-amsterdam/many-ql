package uva.sc.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class VisibilityListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		GUIVisitor visitor = GUIVisitor.getInstance();
		Component component = (Component) e.getSource();
		List<String> dependentElements = visitor.getDependentElements().get(component.getName());
		for (String element : dependentElements) {
			if (visitor.getComponentByName(element).isVisible()) {
				visitor.getComponentByName(element).setVisible(false);
			}
			else {
				visitor.getComponentByName(element).setVisible(true);
			}
		}
	}
}
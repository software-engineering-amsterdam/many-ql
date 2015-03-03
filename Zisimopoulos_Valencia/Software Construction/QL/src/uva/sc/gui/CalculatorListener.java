package uva.sc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JCheckBox;

public class CalculatorListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		GUIVisitor visitor = GUIVisitor.getInstance();
		JCheckBox component = (JCheckBox) e.getSource();
		List<String> dependentElements = visitor.getDependentElements().get(component.getName());
		for (String element : dependentElements) {
			
		}
	}
}
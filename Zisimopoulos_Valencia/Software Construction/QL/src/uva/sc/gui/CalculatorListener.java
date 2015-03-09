package uva.sc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uva.sc.atom.NumberAtom;

public class CalculatorListener implements ActionListener {

	GUIVisitor visitor;
	
	public CalculatorListener (GUIVisitor vis){
		visitor = vis;
	}
	
	public void actionPerformed(ActionEvent e) {
		JTextField component = (JTextField) e.getSource();
		//TODO: check format of the given text
		NumberAtom value = new NumberAtom(component.getText());
		
		DisplayData d = visitor.evaluator.getValuesTable().get(component.getName());
		DisplayData data= new DisplayData(value, d.getCondition());
		visitor.evaluator.getValuesTable().put(component.getName(), data);
		
		List<String> dependentElements = visitor.getDependentElements().get(component.getName());
		for (String element : dependentElements) {
			BigDecimal v = new BigDecimal(visitor.evaluator.getValuesTable().get(element).getValue().accept(visitor.evaluator).getValue());
			JTextField text = (JTextField)(((JPanel)visitor.getComponentByName(element)).getComponent(2));
			text.setText(v.toString());
		}
	}
}
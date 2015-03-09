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

import uva.sc.atom.BooleanAtom;
import uva.sc.evaluator.EvaluatorVisitor;

public class VisibilityListener implements ActionListener {

	GUIVisitor visitor;
	public VisibilityListener (GUIVisitor vis){
		visitor = vis;
	}
	
	public void actionPerformed(ActionEvent e) {
		Component component = (Component) e.getSource();
		DisplayData d = visitor.evaluator.getValuesTable().get(component.getName());
		boolean value = true;
		if(d.getValue() != null){
			value = !(Boolean.valueOf(d.getValue().getValue()));
		}
		DisplayData data = new DisplayData(new BooleanAtom(value), d.getCondition());
		visitor.evaluator.getValuesTable().put(component.getName(), data);
		List<String> dependentElements = visitor.getDependentElements().get(component.getName());
		for (String element : dependentElements) {
			//System.out.println(element);
			//System.out.println(visitor.evaluator.getValuesTable().get(element).getCondition().getValue());
			boolean v = Boolean.valueOf(visitor.evaluator.getValuesTable().get(element).getCondition().accept(visitor.evaluator).getValue());
			visitor.getComponentByName(element).setVisible(v);
		}
	}
}
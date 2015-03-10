package uva.sc.ql.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import uva.sc.ql.atom.BooleanAtom;

public class VisibilityListener implements ActionListener {

	GUIVisitor	visitor;

	public VisibilityListener(GUIVisitor vis) {
		visitor = vis;
	}

	public void actionPerformed(ActionEvent e) {
		Component component = (Component) e.getSource();
		DisplayData d = visitor.evaluator.getValuesTable().get(component.getName());
		boolean value = true;
		if (d.getValue() != null) {
			value = !(Boolean.valueOf(d.getValue().getValue()));
		}
		DisplayData data = new DisplayData(new BooleanAtom(value), d.getCondition());
		visitor.evaluator.getValuesTable().put(component.getName(), data);
		List<String> dependentElements = visitor.getDependentElements().get(component.getName());
		for (String element : dependentElements) {
			boolean v = Boolean.valueOf(visitor.evaluator.getValuesTable().get(element).getCondition().accept(visitor.evaluator).getValue());
			visitor.getComponentByName(element).setVisible(v);
		}
	}
}
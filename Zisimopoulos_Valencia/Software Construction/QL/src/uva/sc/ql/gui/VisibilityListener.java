package uva.sc.ql.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;

import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.evaluator.EvaluatorVisitor;

public class VisibilityListener extends GUIListener implements ActionListener, Observer {

    EvaluatorVisitor evalVisitor;
    List<Component> componentList;
    Map<String, List<String>> dependentElements;
    JCheckBox checkBox;

    public VisibilityListener(Map<String, List<String>> d, EvaluatorVisitor v, List<Component> c, JCheckBox b) {
	dependentElements = d;
	evalVisitor = v;
	componentList = c;
	checkBox = b;
	evalVisitor.addObserver(this);
    }

    public void actionPerformed(ActionEvent e) {
//	Component component = (Component) e.getSource();
	DisplayData d = evalVisitor.getValuesTable()
		.get(checkBox.getName());
	boolean value = true;
	if (d.getValue() != null) {
	    BooleanAtom b = new BooleanAtom((Boolean) (d.getValue().getValue()));
	    value = !(b.getValue());
	}
	DisplayData data = new DisplayData(new BooleanAtom(value), d.getCondition(), d.getType());
	evalVisitor.putToValuesTable(checkBox.getName(), data);
    }

    @Override
    public void update(Observable o, Object arg) {
	List<String> elements = dependentElements.get(checkBox.getName());
	for (String element : elements) {
	    BooleanAtom b = (BooleanAtom) evalVisitor
		    .getValuesTable().get(element).getCondition()
		    .accept(evalVisitor);
	    boolean v = Boolean.valueOf(b.getValue());
	    getComponentByName(element, componentList).setVisible(v);
	}
    }
}
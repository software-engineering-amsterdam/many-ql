package uva.sc.ql.gui.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;

import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.gui.helpers.DisplayData;
import uva.sc.ql.gui.helpers.ListenerHelper;

@SuppressWarnings({ "unchecked" })
public class VisibilityListener implements ActionListener,
	Observer {

    EvaluatorVisitor evalVisitor;
    List<Component> componentList;
    Map<ID, List<ID>> patronElements;
    JCheckBox checkBox;
    ID id;

    public VisibilityListener(Map<ID, List<ID>> d, EvaluatorVisitor v,
	    List<Component> c, JCheckBox b, ID i) {
	patronElements = d;
	evalVisitor = v;
	componentList = c;
	checkBox = b;
	id = i;
	evalVisitor.addObserver(this);
    }

    public void actionPerformed(ActionEvent e) {
	DisplayData d = evalVisitor.getValuesTable().get(id);
	boolean value = true;
	if (d.getValue() != null) {
	    BooleanAtom b = new BooleanAtom((Boolean) (d.getValue().getValue()));
	    value = !(b.getValue());
	}
	DisplayData data = new DisplayData(new BooleanAtom(value),
		d.getCondition(), d.getType());
	evalVisitor.putToValuesTable(id, data);
    }

    @Override
    public void update(Observable o, Object arg) {
	ListenerHelper helper = new ListenerHelper();
	List<ID> elements = patronElements.get(id);
	for (ID element : elements) {
	    BooleanAtom b = (BooleanAtom) evalVisitor.getValuesTable()
		    .get(element).getCondition().accept(evalVisitor);
	    boolean v = Boolean.valueOf(b.getValue());
	    Component com = helper.getComponentByName(element, componentList);
	    com.setVisible(v);
	}
    }
}
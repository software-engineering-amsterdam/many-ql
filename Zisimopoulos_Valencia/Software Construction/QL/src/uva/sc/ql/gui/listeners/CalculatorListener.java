package uva.sc.ql.gui.listeners;

import java.awt.Component;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import uva.sc.ql.atom.ID;
import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.gui.helpers.DisplayData;
import uva.sc.ql.gui.helpers.ListenerHelper;

@SuppressWarnings({ "unchecked" })
public class CalculatorListener implements
	DocumentListener, Observer {

    EvaluatorVisitor evalVisitor;
    List<Component> componentList;
    Map<ID, List<ID>> patronElements;
    JTextField textField;
    ID id;

    public CalculatorListener(Map<ID, List<ID>> d, EvaluatorVisitor v,
	    List<Component> c, JTextField field, ID i) {
	patronElements = d;
	evalVisitor = v;
	componentList = c;
	textField = field;
	id =i;
	evalVisitor.addObserver(this);
    }

    public void changedUpdate(DocumentEvent e) {
	update(e);
    }

    public void insertUpdate(DocumentEvent e) {
	update(e);
    }

    public void removeUpdate(DocumentEvent e) {
	update(e);
    }

    public void update(DocumentEvent e) {
	NumberAtom value = new NumberAtom(0.);
	try {
	    value = new NumberAtom(Double.valueOf(textField.getText()));
	} catch (Exception ex) {
	} finally {
	    DisplayData d = evalVisitor.getValuesTable().get(id);
	    DisplayData data = new DisplayData(value, d.getCondition(),
		    d.getType());
	    evalVisitor.putToValuesTable(id, data);
	}
    }

    @Override
    public void update(Observable o, Object arg) {
	List<ID> elements = patronElements.get(id);
	for (ID element : elements) {
	    ListenerHelper helper = new ListenerHelper();
	    JTextField text = (JTextField) (((JPanel) helper.getComponentByName(
		    element, componentList)).getComponent(2));
	    try {
		NumberAtom n = (NumberAtom) evalVisitor.getValuesTable()
			.get(element).getValue().accept(evalVisitor);
		BigDecimal v = new BigDecimal(n.getValue());

		text.setText(v.toString());
	    } catch (IllegalArgumentException exception) {
		text.setText("-");
	    }
	}
    }
}
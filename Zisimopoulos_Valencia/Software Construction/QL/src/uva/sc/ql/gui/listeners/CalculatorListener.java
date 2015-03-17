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

import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.gui.helpers.DisplayData;
import uva.sc.ql.gui.helpers.ListenerHelper;

public class CalculatorListener implements
	DocumentListener, Observer {

    EvaluatorVisitor evalVisitor;
    List<Component> componentList;
    Map<String, List<String>> dependentElements;
    JTextField textField;

    public CalculatorListener(Map<String, List<String>> d, EvaluatorVisitor v,
	    List<Component> c, JTextField field) {
	dependentElements = d;
	evalVisitor = v;
	componentList = c;
	textField = field;
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
	    DisplayData d = evalVisitor.getValuesTable().get(
		    textField.getName());
	    DisplayData data = new DisplayData(value, d.getCondition(),
		    d.getType());
	    evalVisitor.putToValuesTable(textField.getName(), data);
	}
    }

    @Override
    public void update(Observable o, Object arg) {
	List<String> elements = dependentElements.get(textField.getName());
	for (String element : elements) {
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
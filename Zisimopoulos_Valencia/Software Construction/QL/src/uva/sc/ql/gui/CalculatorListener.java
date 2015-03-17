package uva.sc.ql.gui;

import java.awt.Component;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.evaluator.EvaluatorVisitor;

public class CalculatorListener extends GUIListener implements DocumentListener, Observer {

    EvaluatorVisitor evalVisitor;
    List<Component> componentList;
    Map<String, List<String>> dependentElements;
    JTextField textField;
    
    public CalculatorListener(Map<String, List<String>> d, EvaluatorVisitor v, List<Component> c, JTextField field) {
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
	// TODO: check format of the given text
	NumberAtom value = new NumberAtom(0.);
	try{
	    value = new NumberAtom(Double.valueOf(textField.getText()));
	}
	catch (Exception ex){
	}
	finally{
	    DisplayData d = evalVisitor.getValuesTable().get(
		    textField.getName());
	    DisplayData data = new DisplayData(value, d.getCondition(), d.getType());
	    evalVisitor.putToValuesTable(textField.getName(), data);
	}
    }

    @Override
    public void update(Observable o, Object arg) {
	List<String> elements = dependentElements.get(
		textField.getName());
	for (String element : elements) {
	    JTextField text = (JTextField) (((JPanel) getComponentByName(element, componentList)).getComponent(2));
	    try {
		NumberAtom n = (NumberAtom) evalVisitor.getValuesTable()
			.get(element).getValue().accept(evalVisitor);
		BigDecimal v = new BigDecimal(n.getValue());

		text.setText(v.toString());
	    } catch (IllegalArgumentException exception) {
		text.setText("Illegal Argument in "
			+ ((JLabel) ((JPanel) textField.getParent())
				.getComponent(0)).getText());
	    }
	}
    }
}
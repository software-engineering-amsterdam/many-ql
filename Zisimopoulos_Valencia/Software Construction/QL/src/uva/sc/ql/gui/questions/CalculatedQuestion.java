package uva.sc.ql.gui.questions;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.atom.StringAtom;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.gui.helpers.DisplayData;
import uva.sc.ql.gui.listeners.CalculatorListener;

@SuppressWarnings({ "unchecked", "serial" })
public class CalculatedQuestion extends Question {

    Map<ID, List<ID>> patronElements;
    EvaluatorVisitor evaluator;
    List<Component> componentList;

    public CalculatedQuestion(Map<ID, List<ID>> d,
	    EvaluatorVisitor evalVisitor, List<Component> componentList) {
	this.patronElements = d;
	this.evaluator = evalVisitor;
	this.componentList = componentList;
    }

    public JPanel drawQuestion(ID id, String label, boolean isEditable) {
	DisplayData data = evaluator.getValuesTable().get(id);
	boolean visibility = true;

	JPanel panel = new JPanel();
	JTextField textField = new JTextField();
	textField.setName(id.getValue());

	for (Entry<ID, List<ID>> entry : patronElements.entrySet()) {
	    if (id.equals(entry.getKey())) {
		textField.getDocument().addDocumentListener(
			(new CalculatorListener(patronElements, evaluator,
				componentList, textField, id)));
	    }
	}

	panel.setLayout(new GridLayout(2, 0));
	panel.add(new JLabel(label));
	panel.add(Box.createRigidArea(new Dimension(0, 5)));
	if (data != null) {
	    if (!isEditable) {
		try {
		    StringAtom e = (StringAtom) data.getValue().accept(
			    evaluator);
		    textField = new JTextField(e.getValue());
		} catch (Exception exception) {
		}
	    }
	    textField.setEditable(isEditable);

	    if (data.getCondition() != null) {
		BooleanAtom b = (BooleanAtom) data.getCondition().accept(
			evaluator);
		visibility = b.getValue();
	    }
	}
	panel.add(textField);
	panel.setName(id.getValue());
	panel.setVisible(visibility);
	return panel;
    }

}

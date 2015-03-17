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
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.gui.helpers.DisplayData;
import uva.sc.ql.gui.listeners.CalculatorListener;

@SuppressWarnings("serial")
public class TextBoxQuestion extends Question {

    Map<String, List<String>> dependentElements;
    EvaluatorVisitor evaluator;
    List<Component> componentList;

    public TextBoxQuestion(Map<String, List<String>> dependentElements,
	    EvaluatorVisitor evalVisitor, List<Component> componentList) {
	this.dependentElements = dependentElements;
	this.evaluator = evalVisitor;
	this.componentList = componentList;
    }

    public JPanel drawQuestion(String id, String label, boolean isEditable) {
	DisplayData data = evaluator.getValuesTable().get(id);
	boolean visibility = true;
	JPanel panel = new JPanel();

	JTextField textField = new JTextField();
	textField.setName(id);

	for (Entry<String, List<String>> entry : dependentElements.entrySet()) {
	    if (id.equals(entry.getKey())) {
		textField.getDocument().addDocumentListener(
			(new CalculatorListener(dependentElements, evaluator,
				componentList, textField)));
	    }
	}

	if (data != null) {
	    if (data.getCondition() != null) {
		BooleanAtom b = (BooleanAtom) data.getCondition().accept(
			evaluator);
		visibility = b.getValue();
	    }
	}

	panel.setLayout(new GridLayout(2, 0));
	panel.add(new JLabel(label));
	panel.add(Box.createRigidArea(new Dimension(0, 5)));
	panel.add(textField);
	panel.setName(id);
	panel.setVisible(visibility);
	return panel;
    }

}

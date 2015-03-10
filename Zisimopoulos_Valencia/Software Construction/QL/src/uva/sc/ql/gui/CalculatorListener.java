package uva.sc.ql.gui;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import uva.sc.ql.atom.NumberAtom;

public class CalculatorListener implements DocumentListener {

	GUIVisitor	visitor;
	JTextField	textField;

	public CalculatorListener(GUIVisitor vis, JTextField field) {
		visitor = vis;
		textField = field;
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
		NumberAtom value = new NumberAtom(textField.getText());

		DisplayData d = visitor.evaluator.getValuesTable().get(textField.getName());
		DisplayData data = new DisplayData(value, d.getCondition());
		visitor.evaluator.getValuesTable().put(textField.getName(), data);

		List<String> dependentElements = visitor.getDependentElements().get(textField.getName());
		for (String element : dependentElements) {
			JTextField text = (JTextField) (((JPanel) visitor.getComponentByName(element)).getComponent(2));
			try {
				BigDecimal v = new BigDecimal(visitor.evaluator.getValuesTable().get(element).getValue().accept(visitor.evaluator).getValue());

				text.setText(v.toString());
			}
			catch (IllegalArgumentException exception) {
				text.setText("Illegal Argument in " + ((JLabel) ((JPanel) textField.getParent()).getComponent(0)).getText());
			}
		}
	}
}
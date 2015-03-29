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

import uva.sc.ql.atom.ID;
import uva.sc.ql.evaluator.QuestionsPropertiesVisitor;
import uva.sc.ql.expression.Expression;
import uva.sc.ql.gui.helpers.QuestionData;
import uva.sc.ql.gui.listeners.CalculatorListener;

@SuppressWarnings({ "serial", "rawtypes" })
public class CalculatedQuestion extends Question {

    Map<ID, List<ID>> patronElements;
    QuestionsPropertiesVisitor questionProperties;
    List<Component> componentList;

    public CalculatedQuestion(Map<ID, List<ID>> d,
	    QuestionsPropertiesVisitor questionProperties, List<Component> componentList) {
	this.patronElements = d;
	this.questionProperties = questionProperties;
	this.componentList = componentList;
    }

    public JPanel drawQuestion(ID id, String label, boolean editable) {

	QuestionData data = questionProperties.questionData(id);
	boolean visibility = data.evaluateVisibility(questionProperties.getValuesTable());
	JTextField textField = createTextField(id, editable, data);
	return generatePanel(id, label, visibility, textField);
    }

    private JTextField createTextField(ID id, boolean editable, QuestionData data) {
	JTextField textField = new JTextField();
	String value = calculateText(data);
	textField.setText(value);
	textField.setEditable(editable);
	textField.setName(id.getValue());
	addListeners(id, textField);
	return textField;
    }

    private String calculateText(QuestionData data) {
	String value = "";
	Expression expr = data.evaluateValue(questionProperties.getValuesTable());
	if (expr != null) {
	    value = expr.toString();
	}
	return value;
    }

    private JPanel generatePanel(ID id, String label, boolean visibility,
	    JTextField textField) {
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(2, 0));
	panel.add(new JLabel(label));
	panel.add(Box.createRigidArea(new Dimension(0, 5)));
	
	panel.add(textField);
	panel.setName(id.getValue());
	panel.setVisible(visibility);
	return panel;
    }

    private void addListeners(ID id, JTextField textField) {
	for (Entry<ID, List<ID>> entry : patronElements.entrySet()) {
	    addListener(id, textField, entry);
	}
    }

    private void addListener(ID id, JTextField textField,
	    Entry<ID, List<ID>> entry) {
	if (id.equals(entry.getKey())) {
	    textField.getDocument().addDocumentListener(
		    (new CalculatorListener(patronElements, questionProperties,
			    componentList, textField, id)));
	}
    }

}

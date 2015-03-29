package uva.sc.ql.gui.listeners;

import java.awt.Component;
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
import uva.sc.ql.evaluator.QuestionsPropertiesVisitor;
import uva.sc.ql.gui.helpers.QuestionData;
import uva.sc.ql.gui.helpers.ListenerHelper;

public class CalculatorListener implements DocumentListener, Observer {

    QuestionsPropertiesVisitor questionsProperties;
    List<Component> componentList;
    Map<ID, List<ID>> patronElements;
    JTextField textField;
    ID id;

    public CalculatorListener(Map<ID, List<ID>> patronElements, QuestionsPropertiesVisitor questionsProperties,
	    List<Component> componentList, JTextField textField, ID id) {
	this.patronElements = patronElements;
	this.questionsProperties = questionsProperties;
	this.componentList = componentList;
	this.textField = textField;
	this.id = id;
	this.questionsProperties.addObserver(this);
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
	    QuestionData data = questionsProperties.questionData(id);
	    data = new QuestionData(value, data.getVisibility());
	    questionsProperties.putToValuesTable(id, data);
	}
    }

    public void update(Observable o, Object arg) {
	List<ID> elements = patronElements.get(id);
	for (ID element : elements) {
	    updateTextField(element);
	}
    }

    private void updateTextField(ID element) {
	JTextField textField = getTextField(element);
	QuestionData data = questionsProperties.questionData(element);
	NumberAtom number = (NumberAtom) data.evaluateValue(questionsProperties.getValuesTable());
	Double value = number.getValue();
	if (Double.isFinite(value)) {
	    textField.setText(value.toString());
	} else {
	    textField.setText("-");
	}
    }

    private JTextField getTextField(ID element) {
	ListenerHelper helper = new ListenerHelper();
	JPanel panel = (JPanel) helper.getComponentByName(element, componentList);
	JTextField textField = (JTextField) panel.getComponent(2);
	return textField;
    }
}
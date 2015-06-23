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
import uva.sc.ql.gui.helpers.QuestionData;
import uva.sc.ql.gui.listeners.CalculatorListener;

@SuppressWarnings({ "serial" })
public class TextBoxQuestion extends Question {

    private Map<ID, List<ID>> patronElements;
    private QuestionsPropertiesVisitor questionsProperties;
    private List<Component> componentList;

    public TextBoxQuestion(Map<ID, List<ID>> patronElements,
	    QuestionsPropertiesVisitor questionsProperties,
	    List<Component> componentList) {
	this.patronElements = patronElements;
	this.questionsProperties = questionsProperties;
	this.componentList = componentList;
    }

    public JPanel drawQuestion(ID id, String label, boolean isEditable) {
	QuestionData data = questionsProperties.questionData(id);
	boolean visibility = data.evaluateVisibility(questionsProperties
		.getValuesTable());
	JTextField textField = createTextField(id);
	return generatePanel(id, label, visibility, textField);
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

    private JTextField createTextField(ID id) {
	JTextField textField = new JTextField();
	textField.setName(id.getValue());
	addListeners(id, textField);
	return textField;
    }

    private void addListeners(ID id, JTextField textField) {
	for (Entry<ID, List<ID>> entry : patronElements.entrySet()) {
	    addListener(id, textField, entry);
	}
    }

    private void addListener(ID id, JTextField textField,
	    Entry<ID, List<ID>> entry) {
	if (id.equals(entry.getKey())) {
	    textField.getDocument()
		    .addDocumentListener(
			    (new CalculatorListener(patronElements,
				    questionsProperties, componentList,
				    textField, id)));
	}
    }
}

package uva.sc.ql.gui.questions;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uva.sc.ql.atom.ID;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.gui.listeners.VisibilityListener;

@SuppressWarnings("serial")
public class CheckBoxQuestion extends Question {

    Map<ID, List<ID>> patronElements;
    EvaluatorVisitor evaluator;
    List<Component> componentList;

    public CheckBoxQuestion(Map<ID, List<ID>> d,
	    EvaluatorVisitor evalVisitor, List<Component> componentList) {
	this.patronElements = d;
	this.evaluator = evalVisitor;
	this.componentList = componentList;
    }

    public JPanel drawQuestion(ID id, String label, boolean isEditable) {
	JCheckBox checkBox = new JCheckBox();
	checkBox.setName(id.getValue());

	addListeners(id, checkBox);
	
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(2, 0));
	panel.add(new JLabel(label));
	panel.add(Box.createRigidArea(new Dimension(0, 5)));
	panel.add(checkBox);
	panel.setName(id.getValue());
	return panel;
    }

    private void addListeners(ID id, JCheckBox checkBox) {
	for (Entry<ID, List<ID>> entry : patronElements.entrySet()) {
	    addListener(id, checkBox, entry);
	}
    }

    private void addListener(ID id, JCheckBox checkBox,
	    Entry<ID, List<ID>> entry) {
	if (entry.getKey().equals(id)) {
	    checkBox.addActionListener(new VisibilityListener(
		patronElements, evaluator, componentList, checkBox, id));
	}
    }

}

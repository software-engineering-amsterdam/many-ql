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

import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.gui.listeners.VisibilityListener;

@SuppressWarnings("serial")
public class CheckBoxQuestion extends Question {

    Map<String, List<String>> dependentElements;
    EvaluatorVisitor evaluator;
    List<Component> componentList;

    public CheckBoxQuestion(Map<String, List<String>> dependentElements,
	    EvaluatorVisitor evalVisitor, List<Component> componentList) {
	this.dependentElements = dependentElements;
	this.evaluator = evalVisitor;
	this.componentList = componentList;
    }

    public JPanel drawQuestion(String id, String label, boolean isEditable) {
	JCheckBox checkBox = new JCheckBox();
	checkBox.setName(id);

	for (Entry<String, List<String>> entry : dependentElements.entrySet()) {
	    if (entry.getKey().equals(checkBox.getName())) {
		checkBox.addActionListener(new VisibilityListener(
			dependentElements, evaluator, componentList, checkBox));
	    }
	}

	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(2, 0));
	panel.add(new JLabel(label));
	panel.add(Box.createRigidArea(new Dimension(0, 5)));
	panel.add(checkBox);
	panel.setName(id);
	return panel;
    }

}

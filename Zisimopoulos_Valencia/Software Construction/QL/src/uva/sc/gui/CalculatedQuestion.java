package uva.sc.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uva.sc.evaluator.EvaluatorVisitor;
import uva.sc.logic.Expression;

@SuppressWarnings("serial")
public class CalculatedQuestion extends Question{

	GUIVisitor visitor;
	public CalculatedQuestion(GUIVisitor vis){
		visitor = vis;
	}
	public JPanel drawQuestion(String id, String label) {
		DisplayData data = visitor.evaluator.getValuesTable().get(id);
		boolean visibility = true;
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(new JLabel(label));
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		if (data != null){
			JTextField textfield = new JTextField(data.getValue().accept(visitor.evaluator).getValue());
			textfield.setEditable(false);
			panel.add(textfield);
			if (data.getCondition() != null){
				visibility = Boolean.valueOf(data.getCondition().accept(visitor.evaluator).getValue());
			}
		}
		
		panel.setName(id);
		panel.setVisible(visibility);
		return panel;
	}
	
}

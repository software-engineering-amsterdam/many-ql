package uva.sc.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uva.sc.logic.Expression;

@SuppressWarnings("serial")
public class TextBoxQuestion extends Question{
	
	GUIVisitor visitor;
	
	public TextBoxQuestion(GUIVisitor vis){
		visitor=vis;
	}
	
	public JPanel drawQuestion(String id, String label) {
		DisplayData data = visitor.evaluator.getValuesTable().get(id);
		JTextField textField = new JTextField();
		boolean visibility = true;
		
		textField.setName(id);
		if (data != null){
			if (data.getCondition() != null){
				visibility = Boolean.valueOf(data.getCondition().accept(visitor.evaluator).getValue());
			}
		}
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(new JLabel(label));
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		panel.add(textField);
		panel.setName(id);
		panel.setVisible(visibility);
		return panel;
	}
	
}

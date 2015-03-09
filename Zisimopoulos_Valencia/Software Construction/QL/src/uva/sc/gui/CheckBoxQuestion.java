package uva.sc.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uva.sc.logic.Expression;

@SuppressWarnings("serial")
public class CheckBoxQuestion extends Question{

	public JPanel drawQuestion(String id, String label) {
		JCheckBox checkBox = new JCheckBox();
		checkBox.setName(id);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(new JLabel(label));
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		panel.add(checkBox);
		panel.setName(id);
		return panel;
	}
	
}

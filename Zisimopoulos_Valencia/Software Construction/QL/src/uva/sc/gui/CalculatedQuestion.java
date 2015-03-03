package uva.sc.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CalculatedQuestion extends Question{

	public JPanel drawQuestion(String id, String label, String value) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(new JLabel(label));
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		panel.add(new JTextField(value));
		panel.setName(id);
		return panel;
	}
	
}

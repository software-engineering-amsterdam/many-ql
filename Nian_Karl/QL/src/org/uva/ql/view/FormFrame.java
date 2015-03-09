package org.uva.ql.view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.uva.ql.evaluation.Evaluator;

public class FormFrame extends JFrame {

	private final String identifier;
	private static final long serialVersionUID = 1L;
	private int gridCounterY = 0;
	public FormFrame(String identifier) {
		super("QL Form");
		this.identifier = identifier;
		setSize(600, 800);
		setLayout(new GridBagLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public String getIdentifier() {
		return identifier;
	}
	
	public void addWithConstraints(Component component) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = gridCounterY;
		add(component,constraints);
		gridCounterY++;
	}
	
}

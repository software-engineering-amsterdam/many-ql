package org.uva.ql.view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class FormFrame extends JFrame {

	private final String identifier;
	private static final long serialVersionUID = 1L;

	public FormFrame(String identifier) {
		super("QL Form");
		this.identifier = identifier;
		setSize(400, 800);
		setLayout(new FlowLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public String getIdentifier() {
		return identifier;
	}
}

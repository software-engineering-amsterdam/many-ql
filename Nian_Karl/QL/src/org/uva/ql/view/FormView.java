package org.uva.ql.view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class FormView extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public FormView() {
		super("QL Form.");
		setSize(1200, 400);
        setLayout(new FlowLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
	}
}

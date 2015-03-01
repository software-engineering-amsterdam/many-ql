package org.uva.ql.view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class FormFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public FormFrame() {
		super("QL Form.");
		setSize(400, 600);
        setLayout(new FlowLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
	}
}

package com.form.language.gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.form.language.ast.statement.Form;

public class QuestionFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int weight = 500;
	private static final int height = 500;
    final JPanel formPanel = new JPanel();
    final JPanel container = new JPanel();
	
	public QuestionFrame(final Form form)
	{
		setSize(weight,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        formPanel.add(container);
        getContentPane().add(new JScrollPane(formPanel), BorderLayout.CENTER);

        container.add(form.createGUIComponent());        
        
        setVisible(true);
	}

}

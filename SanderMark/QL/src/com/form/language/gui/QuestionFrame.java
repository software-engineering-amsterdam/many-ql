package com.form.language.gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.form.language.ast.Form;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.gui.components.FormComponent;

public class QuestionFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int weight = 500;
	private static final int height = 500;
	
	public QuestionFrame(final Form form)
	{
		setSize(weight,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
            
        //GUIForm formGUI = new GUIForm(form);
        //add(formGUI);
        
        GUIBuilder guiBuilder = new GUIBuilder(form,this);
        
        setVisible(true);
	}

}

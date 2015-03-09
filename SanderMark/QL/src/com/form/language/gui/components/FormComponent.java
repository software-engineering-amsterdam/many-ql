package com.form.language.gui.components;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.form.language.ast.Form;

public class FormComponent extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public FormComponent(Form form,GUIBuilder guibuilder, JFrame frame)
	{        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //createGUIComponents(this,form,guibuilder);  
	}
}

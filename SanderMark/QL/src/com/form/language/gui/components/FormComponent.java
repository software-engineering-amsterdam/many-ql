package com.form.language.gui.components;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.form.language.ast.Form;
import com.form.language.ast.statement.Statement;

public class FormComponent extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public FormComponent(Form form,GUIBuilder guibuilder, JFrame frame)
	{        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //createGUIComponents(this,form,guibuilder);  
	}
}

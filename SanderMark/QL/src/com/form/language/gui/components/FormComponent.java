package com.form.language.gui.components;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.form.language.ast.Form;

public class FormComponent {

    private JPanel panel;

    public FormComponent(Form form, GUIBuilder guibuilder, JFrame frame) {
    	this.panel = new JPanel();
    	this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
    }
    
    public JPanel getPanel()
    {
    	return this.panel;
    }
}

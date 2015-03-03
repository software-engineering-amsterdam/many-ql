package com.form.language.gui.components;

import java.awt.Component;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.form.language.ast.Form;
import com.form.language.ast.statement.Statement;

public class GUIForm extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public GUIForm(Form form)
	{        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createGUIComponent(this,form);  
	}
	private void createGUIComponent(GUIForm formGUI, Form form) 
	{
		for(Iterator<Statement> s = form.statementList.iterator(); s.hasNext();)
		{
			Statement statement = s.next();
			QuestionComponent component = GUIComponent.createGUIComponent(formGUI,statement); 
			formGUI.add((Component) component);
		}			
	}
}

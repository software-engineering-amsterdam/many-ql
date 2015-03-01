package com.form.language.ast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.form.language.ast.statement.Statement;

public class Form  {
	public String id;
	public List<Statement> statementList;
	private JPanel fPanel;
		
	public Form(String id) {
		this.id = id;
		this.statementList = new ArrayList<Statement>();
	}
	
	public Form(String id, List<Statement> statementList) {
		this.id = id;
		this.statementList = statementList;
	}

	public JComponent createGUIComponent(JPanel panel) {
		fPanel = new JPanel();
		fPanel.setLayout(new BoxLayout(fPanel, BoxLayout.Y_AXIS));
		
		for(Iterator<Statement> s = this.statementList.iterator(); s.hasNext();)
		{
			Statement statement = s.next();
			JComponent component = statement.createGUIComponent(fPanel);
			if(component != null)
			{
				fPanel.add(component);
			}
		}		
		return fPanel;
	}
}

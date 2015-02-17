package com.form.language.ast.statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Form implements Statement {
	public String id;
	public List<Statement> statementList;
	private JPanel fPanel;
		
	public Form(String id) {
		this.id = id;
		this.statementList = new ArrayList<Statement>();
		System.out.println("test1");
	}
	
	public Form(String id, List<Statement> statementList) {
		this.id = id;
		this.statementList = statementList;
		System.out.println("test2");
		System.out.println(id);
	}

	@Override
	public JComponent createGUIComponent() {
		fPanel = new JPanel();
		for(Iterator<Statement> s = this.statementList.iterator(); s.hasNext();)
		{
			Statement statement = s.next();
			JComponent component = statement.createGUIComponent();
			fPanel.add(component);
		}		
		return fPanel;
	}
}

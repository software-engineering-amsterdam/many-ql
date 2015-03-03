package com.form.language.ast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.form.language.ast.statement.Statement;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;

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
		for(Iterator<Statement> s = this.statementList.iterator(); s.hasNext();)
		{
			Statement statement = s.next();
			JComponent component = statement.createGUIComponent(panel);
			if(component != null)
			{
				panel.add(component);
			}
		}		
		return null;
	}
	
	public void getErrors(ErrorCollector errs){
		for(Statement s: statementList){
			s.getErrors(errs);
		}
	}
	public void fillMemory(IdCollector idCollector){
		for(Statement s: statementList){
			s.fillMemory(idCollector);			
		}
		
	}
}

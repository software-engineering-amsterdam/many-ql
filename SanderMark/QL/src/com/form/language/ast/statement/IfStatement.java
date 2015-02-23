package com.form.language.ast.statement;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.form.language.ast.expression.PrimitiveExpression;

public class IfStatement implements Statement {
	public PrimitiveExpression conditions;
	public List<Statement> thenStatements;
	
	//BooleanExpression, get result and cast to boolean
	public IfStatement(PrimitiveExpression conditions, List<Statement> thenStatements) {
		super();
		this.conditions = conditions;
		this.thenStatements = thenStatements;
	}


	@Override
	public JComponent createGUIComponent(JPanel panel) {
		
		
		
		Component[] cArray =  panel.getComponents();	
		for(Component c : cArray)
		{
			c = new JPanel();
			//Component[] ccArray = c.getComponents();
			System.out.println(c.toString());
		}				
		return null;
	}
	
}
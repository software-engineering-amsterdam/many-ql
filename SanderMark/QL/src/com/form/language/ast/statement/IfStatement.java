package com.form.language.ast.statement;

import java.awt.Component;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.error.Error;
import com.form.language.error.ErrorCollector;

public class IfStatement implements Statement {
	public Expression conditions;
	public List<Statement> thenStatements;
	private Token tokenInfo;
	
	//BooleanExpression, get result and cast to boolean
	public IfStatement(Expression conditions, List<Statement> thenStatements, Token tokenInfo) {
		super();
		this.conditions = conditions;
		this.thenStatements = thenStatements;
		this.tokenInfo = tokenInfo;
	}


	@Override
	public Type getType() {
		if (conditions.getType().isBoolType()) return new BoolType();
		else return new ErrorType();
	}


	@Override
	public void getErrors(ErrorCollector errs) {
		conditions.getErrors(errs);
		for(Statement s: thenStatements){
			s.getErrors(errs);
		}
		
		if(!conditions.getType().isBoolType()){
			errs.add(new Error(tokenInfo, "The conditions in an if statement should evaluate to a Boolean"));
		}
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
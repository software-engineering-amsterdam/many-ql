package com.form.language.ast.statement;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.error.Error;
import com.form.language.error.ErrorCollector;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;

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
	public void collectIds(IdCollector idCollector) {
		this.conditions.collectIds(idCollector);
	}


	@Override
	public void setType(IdTypeTable ids) {
		this.conditions.setType(ids);
	}


	@Override
	public void initMemory(RuntimeMemory mem){}


	@Override
	public void createGUIComponent(GUIBuilder guiBuilder, FormComponent formGUI) {
		// TODO Auto-generated method stub
		guiBuilder.createIf(conditions);
		for(Statement s : this.thenStatements)
		{
			s.createGUIComponent(guiBuilder, formGUI);
		}		
	};
		
}
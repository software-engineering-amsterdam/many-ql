package com.form.language.ast.statement;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.Memory;

public class AssignmentStatement implements Statement {
	public String name;
	public Expression expression;
	private Token tokenInfo;
	
	public AssignmentStatement(String name, Expression expression, Token tokenInfo) {
		super();
		this.name = name;
		this.expression = expression;
		this.tokenInfo = tokenInfo;
	}

	@Override
	public JComponent createGUIComponent(JPanel panel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getType() {
		return expression.getType();
	}

	@Override
	public void getErrors(ErrorCollector errs) {
		expression.getErrors(errs);
	}

	@Override
	public void fillMemory(Memory memory) {
		// TODO Auto-generated method stub
		
	}
	
	
}

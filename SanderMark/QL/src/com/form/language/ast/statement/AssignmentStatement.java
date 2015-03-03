package com.form.language.ast.statement;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.IdLiteral;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;

public class AssignmentStatement implements Statement {
	public String id;
	public Type type;
	public Expression expression;
	private Token tokenInfo;
	
	public AssignmentStatement(String id, Type type, Expression expression, Token tokenInfo) {
		super();
		this.id = id;
		this.type = type;
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
	public void collectIds(IdCollector idCollector) {
		// TODO Auto-generated method stub
		//this.expression.fillMemory(memory);
		idCollector.addId(new IdLiteral(id,type,idCollector,null));
	}

	@Override
	public void setType(IdTypeTable ids) {
		this.expression.setType(ids);
	}
	
	public void initMemory(RuntimeMemory mem){
		expression.evaluate(mem).addToMemory(id, mem);
	}
}

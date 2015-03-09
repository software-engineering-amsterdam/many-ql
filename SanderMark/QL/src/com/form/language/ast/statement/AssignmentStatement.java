package com.form.language.ast.statement;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.IdLiteral;
import com.form.language.ast.type.Type;
import com.form.language.error.ErrorCollector;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;
import com.form.language.memory.TypeMemory;

//TODO: ifStatements can be part of a condition, so they will only be assigned conditionally (at runtime). There will be no problems compiletime, however.
public class AssignmentStatement implements Statement {
	public String id;
	public Type type;
	public Expression expression;
	private Token tokenInfo;
	
	public AssignmentStatement(String id, Type type, Expression expression) {
		super();
		this.id = id;
		this.type = type;
		this.expression = expression;
	}

	@Override
	public Type getType(TypeMemory mem) {
		return expression.getType(mem);
	}

//	@Override
//	public void getErrors(ErrorCollector errs) {
//		expression.getErrors(errs);
//	}

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

	@Override
	public void createGUIComponent(GUIBuilder guiBuilder,
			FormComponent formGUI, RuntimeMemory rm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReferences(IdCollector idCollector) {
		this.expression.getReferences(idCollector);
	}
	
	
}

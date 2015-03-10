package com.form.language.ast.statement;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.Context;

//TODO: ifStatements can be part of a condition, so they will only be assigned conditionally (at runtime). There will be no problems compiletime, however.
public class AssignmentStatement implements Statement {
	public String id;
	public Type type;
	public Expression expression;
	//TODO handle tokenInfo in constructor and perhaps in some errors?
	private Token tokenInfo;
	
	public AssignmentStatement(String id, Type type, Expression expression) {
		super();
		this.id = id;
		this.type = type;
		this.expression = expression;
	}

	@Override
	public Type getType(Context context) {
		return expression.getType(context);
	}

	public void initMemory(Context context){
		expression.evaluate(context).addToMemory(id, context);
	}

	@Override
	public void createGUIComponent(GUIBuilder guiBuilder,
			FormComponent formGUI, Context context) {
		// TODO Auto-generated method stub
		
	}
}

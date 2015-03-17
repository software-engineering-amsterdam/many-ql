package com.form.language.ast.statement;

import javax.swing.JPanel;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.Type;
import com.form.language.error.QLToken;
import com.form.language.gui.components.FormComponent;
import com.form.language.memory.Context;

//TODO: ifStatements can be part of a condition, so they will only be assigned conditionally (at runtime). There will be no problems compiletime, however.
public class AssignmentStatement extends Statement {
    private String id;
    //TODO: why don't we use type here?
    private Type type;
    private Expression expression;
    // TODO handle tokenInfo in constructor and perhaps in some errors?

    public AssignmentStatement(String id, Type type, Expression expression, QLToken tokenInfo) {
	super(tokenInfo);
	this.id = id;
	this.type = type;
	this.expression = expression;
    }

    @Override
    public Type getType(Context context) {
	return expression.getType(context);
    }
    
    @Override
    public void initMemory(Context context) {
	context.setValue(id, expression.evaluate(context));
    }

    @Override
    public void createGUIComponent(FormComponent guiBuilder, JPanel panel, Context context) {}
}

package com.form.language.ast.statement;

import java.util.List;

import javax.swing.JPanel;

import com.form.language.ast.expression.Expression;
import com.form.language.error.Error;
import com.form.language.error.QLToken;
import com.form.language.gui.components.FormComponent;
import com.form.language.memory.Context;

//TODO :: Seperate ifstatementconditions and ifstatementthenstatement, kent beck / and rule 4: seperate collections of classes
public class IfStatement extends Statement {
    private Expression conditions;
    private List<Statement> thenStatements;

    public IfStatement(Expression conditions, List<Statement> thenStatements, QLToken tokenInfo) {
	super(tokenInfo);
	this.conditions = conditions;
	this.thenStatements = thenStatements;
    }

    @Override
    public boolean checkType(Context context) {
	for (Statement s : thenStatements) {
	    s.checkType(context);
	}
	if (conditions.getType(context).isBoolType()) {
	    return true;
	} else {
	    context.addError(new Error(tokenInfo, "The conditions in an if statement should evaluate to a Boolean"));
	    return false;
	}
    }

    @Override
    public void initMemory(Context mem) {
    }

    @Override
    public void createGUIComponent(FormComponent guiBuilder, JPanel panel, Context rm) {
	guiBuilder.setIfCondition(conditions);
	for (Statement s : this.thenStatements) {
	    s.createGUIComponent(guiBuilder, panel, rm);
	}
    }

}